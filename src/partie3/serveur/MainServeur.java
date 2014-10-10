package partie3.serveur;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServeur {
    public static void main(String[] args) {
        try {

            // Stockage du port
            int port = 1099;
            
            // Creation de l'objet MusicService
            IService service = (IService) UnicastRemoteObject.exportObject(new MusicService(), port);

            // Ouverture du port
            Registry registry = LocateRegistry.createRegistry(port);

            // Bind du service au mot-clé "MusicService"
            registry.rebind("MusicService", service);

            System.out.println("Serveur lance");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
