package Ex2;

import ileiloes.ILeiloes;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    static String serverIP= "localhost";
    static int registerPort = 7000;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(serverIP,registerPort);
            ILeiloes svc=(ILeiloes) registry.lookup("LeilaoServer");
            Scanner scan = new Scanner(System.in);
            int id = 33017;
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