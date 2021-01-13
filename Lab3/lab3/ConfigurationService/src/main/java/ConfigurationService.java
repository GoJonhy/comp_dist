import io.grpc.stub.StreamObserver;
import spread.SpreadConnection;
import spread.SpreadException;
import spread.SpreadGroup;
import spread.SpreadMessage;

import java.net.InetAddress;
import java.util.ArrayList;

public class ConfigurationService {

    static String daemonAddress = "";
    static int daemonPort = 0;
    static SpreadConnection connection;
    static SpreadGroup spreadGroup;
    private static final String user = "ConfigurationService";

    //Get servers
    public static void getClusterGroup(StreamObserver<ArrayList<String>> list) {
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
        list.onNext(followers);
        list.onCompleted();
    }
}
