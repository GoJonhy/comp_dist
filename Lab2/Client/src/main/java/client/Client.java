package client;

import io.grpc.ConnectivityState;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.ControlServiceGrpc;
import rpcstubs.*;
import rpcstubs.Void;
import rpcstubs.WarnMsg;

import java.util.Scanner;

public class Client {

    //static String svcIP="localhost";
    //static String svcIP="35.230.146.225";
    //static int svcPort=6000;
    static String svcIP = "35.234.134.33";
    static int svcPort = 7500;

    private static String matricula;
    private static int inPoint;
    private static final Scanner scan = new Scanner(System.in);1
    private static final StreamObserverWarnMsg warnings = new StreamObserverWarnMsg();
    private static StreamObserver<WarnMsg> sendToServer;

    public static void main(String[] args) {

        try {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress(svcIP, svcPort)
                    .usePlaintext()
                    .build();

            ControlServiceGrpc.ControlServiceStub stub = ControlServiceGrpc.newStub(channel);
            StreamObserverClient enterStream = new StreamObserverClient();

            System.out.print("Introduza a sua matrícula: ");
            matricula = scan.nextLine();

            System.out.print("Introduza o ponto a entrar [1-5]: ");
            inPoint = Integer.parseInt(scan.nextLine());

            while (inPoint < 1 || inPoint > 5) {
                System.out.print("Ponto inválido. Selecione um ponto entre 1 e 5: ");
                inPoint = scan.nextInt();
            }

            Initial request = Initial.newBuilder().setId(matricula).setInPoint(inPoint).build();
            stub.enter(request, enterStream);

            while(!enterStream.isCompleted) {
                System.out.println("Active and waiting to Enter... ");
                Thread.sleep(1 * 1000);
            }

            boolean cont = true;
            while (cont) {
                System.out.println("Seleccione uma das seguintes opções: \n" +
                        "1 - Enviar mensagem de aviso; \n" +
                        "2 - Indicar ponto de saída; \n" +
                        "3 - Sair");
                int option = scan.nextInt();

                switch(option) {
                    case 1 :
                        sendWarnMsg(stub);
                        break;
                    case 2 :
                        leave(stub);
                        break;
                    case 3 :
                    default:
                        cont = false;
                        break;
                }
            }

        }catch(Exception ex) {
            ex.printStackTrace();
        }

    }

    private static void sendWarnMsg(ControlServiceGrpc.ControlServiceStub stub) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Digite a sua mensagem: ");
        String msg = scan.nextLine();
        if (sendToServer == null)
            sendToServer = stub.warning(warnings);

        WarnMsg warnMsg = WarnMsg.newBuilder().setId(matricula).setWarning(msg).build();
        sendToServer.onNext(warnMsg);
    }

    private static void leave (ControlServiceGrpc.ControlServiceStub stub) {
        System.out.println("Indique o seu ponto de saída: ");
        int endPoint = scan.nextInt();
        FinalPoint finalPoint = FinalPoint.newBuilder().setId(matricula).setOutPoint(endPoint).build();
        StreamObserverPayment paymentStream = new StreamObserverPayment();
        stub.leave(finalPoint, paymentStream);
        while(!paymentStream.isCompleted) {
            System.out.println("Active and waiting for Payment... ");
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sendToServer.onCompleted();
        sendToServer = null;
    }

    private static class StreamObserverClient implements StreamObserver<Void> {
        public boolean isCompleted = false;
        public boolean isSuccess = false;

        @Override
        public void onNext(Void aVoid) {

        }

        @Override
        public void onError(Throwable throwable) {
            isCompleted = false;
            isSuccess = false;

            System.out.println(throwable.getCause().toString());
            System.out.println(throwable.getMessage());
        }

        @Override
        public void onCompleted() {
            isCompleted = true;
            isSuccess = true;
        }
    }

    private static class StreamObserverWarnMsg implements StreamObserver<rpcstubs.WarnMsg> {

        @Override
        public void onNext(rpcstubs.WarnMsg warnMessage) {
            System.out.println("Warning message \n " +
                    "ID: "+warnMessage.getId() + " \n " +
                    "Message: "+warnMessage.getWarning());
        }

        @Override
        public void onError(Throwable throwable) {

        }

        @Override
        public void onCompleted() {

        }
    }

    private static class StreamObserverPayment implements StreamObserver<Payment> {
        public boolean isCompleted = false;
        public boolean isSuccess = false;
        @Override
        public void onNext(Payment payment) {
            System.out.println("Payment : "+payment.getValue());
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
    }
}
