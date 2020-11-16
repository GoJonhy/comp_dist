package Ex1;

import playgamecontract.Bet;
import playgamecontract.IPlayGame;
import playgamecontract.Reply;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    static String serverIP= "35.230.146.225";
    static int registerPort = 7000;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(serverIP,registerPort);
            IPlayGame svc=(IPlayGame)registry.lookup("GameServer");
            Scanner scan = new Scanner(System.in);
            int id = 33017;
            /*
             * Pérolas:
             * X: 2 ; Y: 1
             * X: 4 ; Y: 2
             * X: 6 ; Y: 0
             *
             */
            System.out.print("X:");
            int x = scan.nextInt();
            System.out.print("Y:");
            int y = scan.nextInt();

            Bet bet = new Bet(id, x, y);
            Reply reply = svc.playGame(bet);

            System.out.printf("Tries: %s, Success: %b, Thing: %s%n", reply.getNtries(), reply.isSuccess(), reply.getThing());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Ex1.Client unhandled exception: " + ex.toString());
        }
    }
}
