package client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import rpcstubs.Msg;
import rpcstubs.SerieOfPrimes;
import rpcstubs.ServiceAulaGrpc;

import java.util.Scanner;

public class Client {

    //static String svcIP="localhost";
    static String svcIP="35.230.146.225";
    static int svcPort=6000;

    public static void main(String[] args) {

        try {
            ManagedChannel channel = ManagedChannelBuilder
                    .forAddress(svcIP, svcPort)
                    .usePlaintext().build();
            // call pingServer
            Msg request = Msg.newBuilder().setTxt("luis").build();
            ServiceAulaGrpc.ServiceAulaBlockingStub blockingStub = 	ServiceAulaGrpc.newBlockingStub(channel);
            Msg rpy = blockingStub.pingServer(request);
            System.out.println("result =" + rpy.getTxt());

//            // call find primes
           ServiceAulaGrpc.ServiceAulaStub noBlockStub=ServiceAulaGrpc.newStub(channel);
           PrimesObserver primesObserver = new PrimesObserver();
            noBlockStub.findPrimes(
                    SerieOfPrimes.newBuilder()
                            .setNumberOfPrimes(500)
                            .setStartNumber(1).build(),
                    primesObserver);


            while (!primesObserver.isCompleted()) {

                System.out.println("doing something");
                Thread.sleep(2000);

            }

            System.out.println("press enter to exit");
            Scanner scan=new Scanner(System.in); scan.nextLine();
        }catch(Exception ex) {
            ex.printStackTrace();
        }


    }
}
