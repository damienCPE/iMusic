package partie3.serveur;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class MusicService implements IService {
	
	private static final long serialVersionUID = 2674880711467464646L;

	/*public String getInformation() throws RemoteException {
		System.out.println("Invocation de la methode getInformation()");
		return "bonjour";
	}*/

	@Override
	public byte[] getInformation(String chemin) throws RemoteException, IOException {
		return Files.readAllBytes(Paths.get(chemin));
	}
}
