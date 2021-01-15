package client;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.*;
import rpcstubs.Void;

import java.util.*;

public class Client {
    static String svcIP = "localhost";
    static int svcPort = 7800;
    static String key = "";
    static String value = "";

    static ArrayList<String> serverList = new ArrayList<>();
    static ConfigurationServiceGrpc.ConfigurationServiceBlockingStub configurationStub;

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            //Connection to Configuration Service
            ManagedChannel configurationServiceChannel = ManagedChannelBuilder
                    .forAddress(svcIP, svcPort)
                    .usePlaintext()
                    .build();

            configurationStub = ConfigurationServiceGrpc.newBlockingStub(configurationServiceChannel);

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
    //private static void chooseAvailableServer() {
        // Blocking stub
        // eg: rply = 127.0.0.1:8080;127.0.0.2:8080;...
        Iterator<ServerFollower> svIterator = configurationStub.getClusterGroup(Void.newBuilder().build());
        System.out.println("Available servers:");
        while (svIterator.hasNext()) {
            String sv = svIterator.next().getIp();
            serverList.add(sv);
            System.out.println(sv);
        }


        if (serverList.isEmpty()) {
            if(askForRetry())
                return chooseAvailableServer(); //Tenta obter servidores outra vez
            else return null; //fecha a instância do cliente
        }


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

        if (serverChannel.getState(true) == ConnectivityState.TRANSIENT_FAILURE) {
            if(askForRetry())
                return chooseAvailableServer(); //Tenta obter servidores outra vez
            else return null; //fecha a instância do cliente
        }

        return ServerGrpc.newStub(serverChannel);
    }

    private static void write (ServerGrpc.ServerStub serverStub) {
        System.out.println("Indique a chave do objecto: \n");
        key = scan.nextLine();
        System.out.println("Indique o valor do objecto: \n");
        value = scan.nextLine();

        write(serverStub, key, value);
    }

    private static void write (ServerGrpc.ServerStub serverStub, String key, String value) {
        Key k = Key.newBuilder().setK(key).build();
        Value v = Value.newBuilder().setV(value).build();

        KeyValuePair req = KeyValuePair.newBuilder().setK(k).setV(v).build();
        StreamObserverWrite responseObserver = new StreamObserverWrite();
        serverStub.write(req, responseObserver);
    }

    private static void read (ServerGrpc.ServerStub serverStub) {
        System.out.println("Indique a chave do objecto: \n");
        key = scan.nextLine();
        read (serverStub, key);
    }

    private static void read (ServerGrpc.ServerStub serverStub, String key) {
        Key req = Key.newBuilder().setK(key).build();
        StreamObserverRead responseObserver = new StreamObserverRead();
        serverStub.read(req, responseObserver);
    }

    private static boolean askForRetry() {

        System.out.println("Retry? \n 1 - Yes \n 2 or other - No \n");
        int option = scan.nextInt();
        return option == 1;
    }
    private static class StreamObserverWrite implements StreamObserver<Void> {
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
    }
    private static class StreamObserverRead implements StreamObserver<Value> {
        public boolean isCompleted = false;
        public boolean isSuccess = false;
        @Override
        public void onNext(Value s) {
            System.out.printf("Object[%s] = %s", key, s.getV());
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
    }
}
