package client;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.ControlServiceGrpc;
import rpcstubs.*;
import rpcstubs.Void;
import rpcstubs.WarnMsg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Client {
    static String svcIP = "localhost";
    static int svcPort = 7500;

    static ArrayList<String> serverList = new ArrayList<>();
    static ConfigurationServiceGrpc.ConfigurationServiceStub configurationStub;

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            //Connection to Configuration Service
            ManagedChannel configurationServiceChannel = ManagedChannelBuilder
                    .forAddress(svcIP, svcPort)
                    .usePlaintext()
                    .build();

            configurationStub = ConfigurationServiceGrpc.newStub(configurationServiceChannel);

            ServerGrpc.ServerStub serverStub = chooseAvailableServer();

            boolean cont = true;
            while (cont) {
                System.out.println("Seleccione uma das seguintes opções: \n" +
                        "1 - Escrever; \n" +
                        "2 - Ler; \n" +
                        "3 - Sair");
                int option = scan.nextInt();

                switch (option) {
                    case 1:
                        if (serverStub != null)
                            write(serverStub);
                        break;
                    case 2:
                        if (serverStub != null)
                            read(serverStub);
                        break;
                    case 3:
                    default:
                        cont = false;
                        break;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String pickRandomServer(List<String> rply) {
        Random r = new Random();
        int low = 10;
        int high = 100;
        int result = r.nextInt(high-low) + low;
        return rply.get(result);
    }

    private static ServerGrpc.ServerStub chooseAvailableServer() {
        // Blocking stub
        // eg: rply = 127.0.0.1:8080;127.0.0.2:8080;...
        StreamObserver<ArrayList<String>> serverObserver = new StreamObserver<>() {
            public boolean isCompleted = false;
            public boolean isSuccess = false;
            @Override
            public void onNext(ArrayList<String> list) {
                serverList.addAll(list);
            }

            @Override
            public void onError(Throwable throwable) {
                isCompleted = true;
                isSuccess = false;
            }

            @Override
            public void onCompleted() {
                isCompleted = true;
                isSuccess = true;
            }
        };
        configurationStub.getClusterGroup(serverObserver);

        serverList.forEach(serverIP -> {
            System.out.println("Available servers:");
            System.out.println(serverIP);
        });

        if (serverList.isEmpty())
            return null;

        // Choosing Random Server (eg: 127.0.0.1:8080)
        String chosenServer = pickRandomServer(serverList);
        String[] splitChosenServer = chosenServer.split(":");
        String serverIP = splitChosenServer[0];
        int serverPort = Integer.parseInt(splitChosenServer[1]);

        System.out.printf("Server chosen: \n IP: %s : %s", serverIP, serverPort);

        ManagedChannel serverChannel = ManagedChannelBuilder
                .forAddress(serverIP, serverPort)
                .usePlaintext()
                .build();

        ServerGrpc.ServerStub serverStub = ServerGrpc.newStub(serverChannel);
        StreamObserver<WarnMsg> sendToServer;

        // ping Server com argumento Void
        StreamObserver<Void> responseObserver = new StreamObserver<>() {
            public boolean isCompleted = false;
            public boolean isSuccess = false;
            @Override
            public void onNext(Void aVoid) {

            }

            @Override
            public void onError(Throwable throwable) {
                isCompleted = true;
                isSuccess = false;
            }

            @Override
            public void onCompleted() {
                isCompleted = true;
                isSuccess = true;
            }
        };
        serverStub.pingServer(responseObserver);

        if (responseObserver.isCompleted && responseObserver.isSuccess)
            return serverStub;
        else
            return chooseAvailableServer();
    }

    private static void write (ServerGrpc.ServerStub serverStub) {
        System.out.println("Indique a chave do objecto: \n");
        String key = scan.nextLine();
        System.out.println("Indique o valor do objecto: \n");
        String value = scan.nextLine();
        ReqWrite req = ReqWrite.newBuilder().setKey(key).setValue(value).build();
        StreamObserver<Void> responseObserver = new StreamObserver<>() {
            public boolean isCompleted = false;
            public boolean isSuccess = false;
            @Override
            public void onNext(Void s) {
            }

            @Override
            public void onError(Throwable throwable) {
                isCompleted = true;
                isSuccess = false;
                System.out.println(throwable.getMessage());
                if(askForRetry()) {
                    ServerGrpc.ServerStub newStub = chooseAvailableServer();
                    if (newStub != null) {
                        write(newStub, key, value);
                    }
                }
            }

            @Override
            public void onCompleted() {
                isCompleted = true;
                isSuccess = true;
            }
        };
        serverStub.write(req, responseObserver);
    }

    private static void write (ServerGrpc.ServerStub serverStub, String key, String value) {
        ReqWrite req = ReqWrite.newBuilder().setKey(key).setValue(value).build();
        StreamObserver<Void> responseObserver = new StreamObserver<>() {
            public boolean isCompleted = false;
            public boolean isSuccess = false;
            @Override
            public void onNext(Void s) {
            }

            @Override
            public void onError(Throwable throwable) {
                isCompleted = true;
                isSuccess = false;
                System.out.println(throwable.getMessage());
                if(askForRetry()) {
                    ServerGrpc.ServerStub newStub = chooseAvailableServer();
                    if (newStub != null) {
                        write(newStub, key, value);
                    }
                }
            }

            @Override
            public void onCompleted() {
                isCompleted = true;
                isSuccess = true;
            }
        };
        serverStub.write(req, responseObserver);
    }

    private static void read (ServerGrpc.ServerStub serverStub) {
        System.out.println("Indique a chave do objecto: \n");
        String key = scan.nextLine();
        ReqRead req = ReqRead.newBuilder().setKey(key).build();
        StreamObserver<String> responseObserver = new StreamObserver<>() {
            public boolean isCompleted = false;
            public boolean isSuccess = false;
            @Override
            public void onNext(String s) {
                System.out.printf("Object[%s] = %s", key, s);
            }

            @Override
            public void onError(Throwable throwable) {
                isCompleted = true;
                isSuccess = false;
                System.out.println(throwable.getMessage());
                if(askForRetry()) {
                    ServerGrpc.ServerStub newStub = chooseAvailableServer();
                    if (newStub != null) {
                        read(newStub, key);
                    }
                }
            }

            @Override
            public void onCompleted() {
                isCompleted = true;
                isSuccess = true;
            }
        };
        serverStub.read(req, responseObserver);
    }

    private static void read (ServerGrpc.ServerStub serverStub, String key) {
        System.out.println("Indique a chave do objecto: \n");
        String key = scan.nextLine();
        ReqRead req = ReqRead.newBuilder().setKey(key).build();
        StreamObserver<String> responseObserver = new StreamObserver<>() {
            public boolean isCompleted = false;
            public boolean isSuccess = false;
            @Override
            public void onNext(String s) {
                System.out.printf("Object[%s] = %s", key, s);
            }

            @Override
            public void onError(Throwable throwable) {
                isCompleted = true;
                isSuccess = false;
                System.out.println(throwable.getMessage());
                System.out.println(throwable.getMessage());
                if(askForRetry()) {
                    ServerGrpc.ServerStub newStub = chooseAvailableServer();
                    if (newStub != null) {
                        read(newStub, key);
                    }
                }
            }

            @Override
            public void onCompleted() {
                isCompleted = true;
                isSuccess = true;
            }
        };
        serverStub.read(req, responseObserver);
    }

    private static boolean askForRetry() {

        System.out.println("Retry? \n 1 - Yes \n 2 or other - No \n");
        int option = scan.nextInt();
        return option == 1;
    }

/*
    //A implementação de pingServer é idêntica à operação case1
    public static void pingServer (Void request, StreamObserver < Void > responseObserver){
        System.out.println("pingServer called");
        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }
*/
}
