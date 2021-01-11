package server;

import centralstubs.CentralServiceGrpc;
import centralstubs.Tariff;
import centralstubs.Track;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.Void;
import rpcstubs.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Server extends ControlServiceGrpc.ControlServiceImplBase {
    static int svcPort=7500;
    static int paymentServerPort = 7500;
    static String paymentServerIP = "35.230.146.225";

    //ID -- Ponto de entrada
    ConcurrentHashMap<String, Integer> cars = new ConcurrentHashMap<>();

    //Lista com os streamobservers que vão receber warningmessages
    ArrayList<StreamObserver<WarnMsg>> replyWarnMsgList = new ArrayList<>();

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
        cars.put(request.getId(), request.getInPoint());
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
        ManagedChannel channel = ManagedChannelBuilder.forAddress(paymentServerIP, paymentServerPort).usePlaintext().build();

        Track trck = Track.newBuilder().setGroup(6).setInPoint(cars.get(request.getId())).setOutPoint(request.getOutPoint()).build();

        CentralServiceGrpc.CentralServiceBlockingStub blockingStub = CentralServiceGrpc.newBlockingStub(channel);
        Tariff trf = blockingStub.payment(trck);
        Payment payment = Payment.newBuilder().setValue(trf.getValue()).build();
        responseObserver.onNext(payment);
        responseObserver.onCompleted();

        System.out.println("Car nº"+request.getId()+" saiu no ponto "+request.getOutPoint());
        cars.remove(request.getId());
    }

    private class ServerStreamObserver implements StreamObserver<WarnMsg> {

        StreamObserver<WarnMsg> clientReplyStream;

        public ServerStreamObserver(StreamObserver<WarnMsg> clientReplyStream) {
            this.clientReplyStream = clientReplyStream;
        }

        @Override
        public void onNext(WarnMsg warnMsg) {
            if (!replyWarnMsgList.contains(clientReplyStream)){
                replyWarnMsgList.add(clientReplyStream);
            }

            ArrayList<StreamObserver<WarnMsg>> streamsToRemove = new ArrayList<>();

            for (StreamObserver<WarnMsg> rpl : replyWarnMsgList) {
               try {
                   rpl.onNext(warnMsg);
               } catch (Exception e) {
                   streamsToRemove.add(rpl);
               }
            }
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("Error oncall:"+throwable.getMessage());
        }

        @Override
        public void onCompleted() {
            clientReplyStream.onCompleted();
            replyWarnMsgList.remove(clientReplyStream);
        }
    }
}
