package Ex2.Server;

import ileilao.ILeiloes;
import ileilao.INotification;
import ileilao.SomeObject;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Server implements ILeiloes {
    static String serverIP="localhost";
    static int registerPort = 7000;
    static int svcPort = 7001;

    //Leiloes a decorrer
    ArrayList<SomeObject> objs = new ArrayList<>();

    //List<INotification> → Posição 0 é o criador do leilao
    Hashtable<String, List<INotification>> cbs = new Hashtable<>();

    public static void main (String[] args) {
        try {
            Properties props = System.getProperties();
            props.put("java.rmi.server.hostname", serverIP);
            Server svc = new Server();
            ILeiloes stubSvc=(ILeiloes) UnicastRemoteObject.exportObject(svc, svcPort);
            Registry registry = LocateRegistry.createRegistry(registerPort);
            registry.rebind("LeilaoServer", stubSvc); //regista skeleton com nome lógico

            System.out.println("Server ready: Press any key to finish server");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            String line = scanner.nextLine();
            System.exit(0);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            System.err.println("Server unhandled exception: " + ex.toString());
        }
    }

    @Override
    public void initLeilao(SomeObject someObject, INotification iNotification) throws RemoteException {
        ArrayList<INotification> aux = new ArrayList<>();
        aux.add(iNotification);

        cbs.put(someObject.getId(), aux);
        objs.add(someObject);
        iNotification.sendNotification("Leilão Aceite");
    }

    @Override
    public SomeObject[] getAllLeiloes() throws RemoteException {
        SomeObject[] ret = new SomeObject[objs.size()];

        for(int i=0 ; i<objs.size() ; i++){
            ret[i] = objs.get(i);
        }

        return ret;
    }

    @Override
    public void licitar(String id, float valor, INotification iNotification) throws RemoteException {
        cbs.get(id).add(iNotification); //Adicionado CB
        for(SomeObject aux : objs) {
            if (aux.getId().equals(id)) {
                if (valor > aux.getVal()) {
                    aux.setVal((double) valor);
                    for(INotification callback : cbs.get(id)) {
                        callback.sendNotification("Licitação feita. Id : "+id+" - Valor: "+valor);
                    }
                }
                break;
            }
        }

    }
}
