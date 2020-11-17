package server;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.*;
import rpcstubs.Void;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Server extends ControlServiceGrpc.ControlServiceImplBase {
    static int svcPort=7000;

    //ID -- Entry Point
    ConcurrentHashMap<String, CarInfo> cars = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        try {
            io.grpc.Server svc = ServerBuilder
                    .forPort(svcPort)
                    .addService(new Server())
                    .build();
            svc.start();
            System.out.println("Server started, listening on " + svcPort);
            Scanner scan=new Scanner(System.in); scan.nextLine();
            svc.shutdown();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void enter(Initial request, StreamObserver<Void> responseObserver) {
        System.out.println("Car nº"+request.getId()+" entrou no ponto "+request.getInPoint());

        cars.put(request.getId(), new CarInfo(request.getInPoint(), null));

        responseObserver.onNext(Void.newBuilder().build());
        responseObserver.onCompleted();
    }

    /*
        O StreamObserver<WarnMsg> que vem por parametro é onde os warning messages são escritos para o cliente.
        O StreamObserver<WarnMsg> que é retornado por este método é onde os clientes inserem os seus warnings.
    */
    @Override
    public StreamObserver<WarnMsg> warning (StreamObserver<WarnMsg> responseObserver) {
        ServerStreamObserver reqs = new ServerStreamObserver(responseObserver);
        return reqs;
    }

    @Override
    public void leave(FinalPoint request, StreamObserver<Payment> responseObserver) {

    }

    private class ServerStreamObserver implements StreamObserver<WarnMsg> {

        StreamObserver<WarnMsg> clientReplyStream;

        public ServerStreamObserver(StreamObserver<WarnMsg> clientReplyStream) {
            this.clientReplyStream = clientReplyStream;
        }

        @Override
        public void onNext(WarnMsg warnMsg) {
            if (warnMsg.getWarning().equals("")){
                CarInfo info = cars.get(warnMsg.getId());
                info.replyToClient = clientReplyStream;
                cars.computeIfPresent(warnMsg.getId(), (key, oldValue) -> info);
            }
            else {
                //Mandar para todos
            }
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onCompleted() {
            clientReplyStream.onCompleted();
        }
    }

    private class CarInfo {
        Integer entrada;
        StreamObserver<WarnMsg> replyToClient;

        public CarInfo(Integer entrada, StreamObserver<WarnMsg> replyToClient) {
            this.entrada = entrada;
            this.replyToClient = replyToClient;
        }
    }
}
