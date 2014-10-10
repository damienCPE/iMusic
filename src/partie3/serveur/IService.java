package partie3.serveur;

import java.io.IOException;
import java.rmi.*;

public interface IService extends Remote {
    public byte[] getInformation(String chemin) throws RemoteException, IOException;
}