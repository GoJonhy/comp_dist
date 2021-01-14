package server;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.Void;
import rpcstubs.*;
import spread.SpreadConnection;
import spread.SpreadException;
import spread.SpreadGroup;
import spread.SpreadMessage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Server extends ServerGrpc.ServerImplBase {
    static int svcPort;
    static String svcIP;

    static SpreadConnection connection;
    static SpreadGroup spreadGroup;

    static String daemonAddress = "";
    static int daemonPort = 0;

    static String monitorIP;
    static int monitorPort;
    static boolean isMonitor = false;

    static ConcurrentHashMap<String, String> db = new ConcurrentHashMap<>();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            System.out.println("Insert VM IP: ");
            svcIP = scan.nextLine();
            System.out.println("Insert Port: ");
            svcPort = scan.nextInt();

            io.grpc.Server svc = ServerBuilder
                    .forPort(svcPort)
                    .addService(new Server())
                    .build();
            svc.start();

            connection = new SpreadConnection();
            connection.connect(InetAddress.getByName(daemonAddress), daemonPort, svcIP+":"+svcPort, false, true);

            spreadGroup = new SpreadGroup();

            spreadGroup.join(connection, "1"); //To join a specific group (1) → Associa connection ao grupo

            System.out.println("Server started, listening on " + svcPort);
            scan.nextLine();
            connection.disconnect();
            svc.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void read(Key request, StreamObserver<Value> responseObserver) {
        String val = db.get(request.getK());
        if (val == null) {
            //Key não existe no servidor
            try{
                SpreadMessage msg = new SpreadMessage();
                msg.setSafe();
                msg.addGroup("1");
                msg.setData("ping".getBytes());
                connection.multicast(msg);
                for (SpreadGroup member : msg.getMembershipInfo().getMembers()) {
                    String[] strSplit = member.toString().split(":");
                    String follwrIP = strSplit[0];
                    int followrPrt = Integer.parseInt(strSplit[1]);
                    ManagedChannel configurationServiceChannel = ManagedChannelBuilder
                            .forAddress(follwrIP, followrPrt)
                            .usePlaintext()
                            .build();

                    ServerGrpc.ServerStub configurationStub = ServerGrpc.newStub(configurationServiceChannel);
                    configurationStub.readChk(request, responseObserver);
                }

            }catch (SpreadException e) {
                e.printStackTrace();
            }
        }
        else {
            //Key existe no servidor
            responseObserver.onNext(Value.newBuilder().setV(val).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void readChk(Key request, StreamObserver<Value> responseObserver) {
        String val = db.get(request.getK());
        if (val == null) {
            //Key não existe no servidor
            responseObserver.onError(new Throwable());
        }
        else {
            //Key existe no servidor
            responseObserver.onNext(Value.newBuilder().setV(val).build());
            responseObserver.onCompleted();
        }
    }

    @Override
    public void write(KeyValuePair request, StreamObserver<Void> responseObserver) {

        /*
          KeyValuePair: {
            k: {
               string k;
            }
            v: {
               string v;
            }
          }
         */
        StreamObserverInvalidateReplica rplcaStream = new StreamObserverInvalidateReplica();
        if(isMonitor) {
            invalidateReplicas(request.getK(), rplcaStream);
        }
        else {
            try{
                SpreadMessage msg = new SpreadMessage();
                msg.setSafe();
                msg.addGroup("1");
                msg.setData("ping".getBytes());
                connection.multicast(msg);
                for (SpreadGroup member : msg.getMembershipInfo().getMembers()) {
                    String[] strSplit = member.toString().split(":");
                    String follwrIP = strSplit[0];
                    int followrPrt = Integer.parseInt(strSplit[1]);
                    ManagedChannel monitorServerChannel = ManagedChannelBuilder
                            .forAddress(follwrIP, followrPrt)
                            .usePlaintext()
                            .build();

                    ServerGrpc.ServerStub monitorStub = ServerGrpc.newStub(monitorServerChannel);
                    monitorStub.invalidateReplicas(request.getK(), rplcaStream);
                    while(!rplcaStream.isCompleted){
                        System.out.println("Waiting For Monitor to conclude Invalidations...");
                        Thread.sleep(4000);
                    }
                }

            }catch (SpreadException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



        db.put(request.getK().getK(), request.getV().getV());

        try {
            //write to file
            File file = new File("db.txt");

            // creates the file
            file.createNewFile();

            // creates a FileWriter Object
            FileWriter writer = new FileWriter(file);

            // Writes the content to the file
            StringBuilder text= new StringBuilder();
            for(Map.Entry<String, String> entry : db.entrySet()) {
                text.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
            writer.write(text.toString());
            writer.flush();
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void electionProcess(Void request, StreamObserver<Void> responseObserver) {
        super.electionProcess(request, responseObserver);
    }

    @Override
    public void stopSelfElection(Void request, StreamObserver<Void> responseObserver) {
        super.stopSelfElection(request, responseObserver);
    }

    @Override
    public void invalidateReplicas(Key request, StreamObserver<Void> responseObserver) {
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void createReplica(KeyValuePair request, StreamObserver<Void> responseObserver) {
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    //Só para exemplo
    private static class StreamObserverCheckObj implements StreamObserver<Value> {
        public boolean isCompleted = false;
        public boolean isSuccess = false;
        /*
            -1 = Nao tem obj ;
            0 = Ainda não respondeu ;
            1 = Tem obj
         */
        public int hasObj = 0;
        @Override
        public void onNext(Value server) {
            hasObj = 1;
        }

        @Override
        public void onError(Throwable throwable) {
            isCompleted = true;
            isSuccess = false;
            hasObj = -1;
            System.out.println(throwable.getMessage());
        }

        @Override
        public void onCompleted() {
            isCompleted = true;
            isSuccess = true;
        }
    }

    private static class StreamObserverInvalidateReplica implements StreamObserver<Void> {
        public boolean isCompleted = false;
        public boolean isSuccess = false;
        /*
            0 = Ainda não respondeu ;
            1 = invalidou
         */
        public boolean invalidation = false;
        @Override
        public void onNext(Void server) {
            invalidation = true;
        }

        @Override
        public void onError(Throwable throwable) {
            isCompleted = true;
            isSuccess = false;
            System.out.println(throwable.getMessage());
        }

        @Override
        public void onCompleted() {
            isCompleted = true;
            isSuccess = true;
        }
    }
}
