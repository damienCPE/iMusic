package partie3.serveur;

import java.rmi.*;

public interface IService extends Remote {
    public String getInformation() throws RemoteException;
}