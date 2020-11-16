package server;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.Msg;
import rpcstubs.Prime;
import rpcstubs.SerieOfPrimes;
import rpcstubs.ServiceAulaGrpc;

import java.util.Scanner;

public class Server  extends ServiceAulaGrpc.ServiceAulaImplBase {
    static int svcPort=6000;
    public static void main(String[] args) {
        try {
            if (args.length > 0) svcPort=Integer.parseInt(args[0]);

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
    public void pingServer(Msg request, StreamObserver<Msg> responseObserver) {
        Msg msgout=Msg.newBuilder().setTxt(request.getTxt()+" : server is alive").build();
        responseObserver.onNext(msgout);
        responseObserver.onCompleted();
    }

    @Override
    public void findPrimes(SerieOfPrimes request, StreamObserver<Prime> responseObserver) {
        int contPrimes = 0;
        int seqNum = request.getStartNumber(); // startNum > 1
        if (seqNum % 2 ==0) seqNum++;
        while (contPrimes < request.getNumberOfPrimes()) {
            if (isPrime(seqNum)) {
                responseObserver.onNext(
                        Prime.newBuilder().setNumber(seqNum).build());
                contPrimes++;
            }
            seqNum+=2;
        }
        responseObserver.onCompleted();

     }

    static boolean isPrime(int num) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0) return false;
        for (int i=3; i <= Math.sqrt(num); i+=2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
