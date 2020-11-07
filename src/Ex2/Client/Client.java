package Ex2.Client;

import ileilao.ILeiloes;
import ileilao.INotification;
import ileilao.SomeObject;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements INotification{
    static String serverIP= "localhost";
    static int registerPort = 7000;
    static Scanner scan = new Scanner(System.in);

    protected Client() throws RemoteException {
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(serverIP,registerPort);
            ILeiloes svc=(ILeiloes) registry.lookup("LeilaoServer");

            System.out.println("Menu:\n" +
                    "1 - Criar novo leilão;\n" +
                    "2 - Licitar em leilão decorrente\n");
            System.out.print("-> ");

            String option = scan.nextLine();

            switch (option) {
                case "1" : createLeilao(svc); break;
                case "2" : licitar(svc); break;
                default : System.out.println("Opção não existe");
            }

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Ex1.Client unhandled exception: " + ex.toString());
        }
    }

    private static void licitar(ILeiloes svc) throws RemoteException{
        SomeObject[] objs = svc.getAllLeiloes();

        for(SomeObject obj : objs)
            System.out.println("ID: "+obj.getId()+" ; Descrição: "+ obj.getDesc() + " ; Valor: "+obj.getVal());

        System.out.println("Escolha o objecto para licitar: ");
        String id = scan.nextLine();

        System.out.println("Indique o valor: ");
        float valor = scan.nextFloat();

        Client lClient = new Client();
        svc.licitar(id, valor, lClient);
    }

    private static void createLeilao(ILeiloes svc) throws RemoteException{

        System.out.println("Insira o ID do objecto");
        String id = scan.nextLine();
        System.out.println("Insira a descrição do objecto");
        String desc = scan.nextLine();
        System.out.println("Insira o valor inicial do objecto");
        double valor = scan.nextDouble();

        SomeObject newObj = new SomeObject();
        newObj.setId(id);
        newObj.setDesc(desc);
        newObj.setVal(valor);
        Client lClient = new Client();
        svc.initLeilao(newObj, lClient);
    }

    @Override
    public void sendNotification(String s) throws RemoteException {
        System.out.println(s);
    }
}