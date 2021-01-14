import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import rpcstubs.Void;
import spread.SpreadConnection;
import spread.SpreadException;
import spread.SpreadGroup;
import spread.SpreadMessage;
import rpcstubs.*;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Scanner;

public class ConfigurationService extends ConfigurationServiceGrpc.ConfigurationServiceImplBase {

    static int svcPort = 7800;

    static String daemonAddress = "";
    static int daemonPort = 0;
    static SpreadConnection connection;
    static SpreadGroup spreadGroup;
    private static final String user = "ConfigurationService";

    public static void main (String[] args) {
        try {
            io.grpc.Server svc = ServerBuilder
                    .forPort(svcPort)
                    .addService(new ConfigurationService())
                    .build();
            svc.start();
            System.out.println("Configuration Service started, listening on " + svcPort);

            Scanner scan=new Scanner(System.in); scan.nextLine();
            svc.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getClusterGroup(Void request, StreamObserver<ServerFollower> responseObserver) {
        ArrayList<String> followers = new ArrayList<String>();


        /*if (connection == null) {
            try {
                connection = new SpreadConnection();
                connection.connect(InetAddress.getByName(daemonAddress), daemonPort, user, false, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //connection.disconnect();
        }

        if (spreadGroup == null) {
            spreadGroup = new SpreadGroup();
            try {
                spreadGroup.join(connection, "1"); //To join a specific group (1) → Associa connection ao grupo
                SpreadMessage msg = new SpreadMessage();
                msg.setSafe();
                msg.addGroup("1");
                msg.setData("ping".getBytes());
                connection.multicast(msg);
                for (SpreadGroup member : msg.getMembershipInfo().getMembers())
                    followers.add(member.toString());
                followers.remove(user);
            } catch (SpreadException e) {
                e.printStackTrace();
            }
        }*/
        followers.add("111.111.111:89");
        followers.add("222.222.222:91");
        followers.forEach( it -> {
            ServerFollower sv = ServerFollower.newBuilder().setIp(it).build();
            responseObserver.onNext(sv);
        });

        responseObserver.onCompleted();
    }

/*
    //Get servers
    @Override
    public static void test(StreamObserver<ServerFollower> list) {
        ArrayList<String> followers = new ArrayList<String>();
        if (connection == null) {
            try {
                connection = new SpreadConnection();
                connection.connect(InetAddress.getByName(daemonAddress), daemonPort, user, false, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //connection.disconnect();
        }
        if (spreadGroup == null) {
            spreadGroup = new SpreadGroup();
            try {
                spreadGroup.join(connection, "1"); //To join a specific group (1) → Associa connection ao grupo
                SpreadMessage msg = new SpreadMessage();
                msg.setSafe();
                msg.addGroup("1");
                msg.setData("ping".getBytes());
                connection.multicast(msg);
                for (SpreadGroup member : msg.getMembershipInfo().getMembers())
                    followers.add(member.toString());
                followers.remove(user);
            } catch (SpreadException e) {
                e.printStackTrace();
            }
        }
        followers.forEach( it -> {
            ServerFollower sv = ServerFollower.newBuilder().setIp(it).build();
            list.onNext(sv);
        });

        list.onCompleted();
    }
    */
}
