package partie3.model;

import java.io.File;
import java.rmi.registry.Registry;

import partie1.model.Musique;

public class MusiqueFichierServer extends Musique{ 
	String chemin;
	
	public MusiqueFichierServer(String s){
		/*this.chemin = s;
		ServiceInterface stub;
		try
		{
			// Initialisation du registry sur le port 1099
			Registry registry = LocateRegistry.getRegistry(1099);
			
			// Récupération du stub lié au serveur
			this.stub = (ServiceInterface) registry.lookup("MusicService");
		}
		catch (Exception e) {
			
		}*/
		
	}

	@Override
	public int creationPiste() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
