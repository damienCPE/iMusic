package partie3.serveur;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class MusicService extends UnicastRemoteObject implements IService {

	protected MusicService() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	protected MusicService(int port) throws RemoteException {
		super(port);
		// TODO Auto-generated constructor stub
	}

	protected MusicService(int port, RMIClientSocketFactory csf,
			RMIServerSocketFactory ssf) throws RemoteException {
		super(port, csf, ssf);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 2674880711467464646L;

	public String getInformation() throws RemoteException {
		System.out.println("Invocation de la methode getInformation()");
		return "bonjour";
	}
}
