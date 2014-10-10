package partie3.serveur;

import java.rmi.*;

public interface IServeurRMI extends Remote {
    public String getInformation() throws RemoteException;
}