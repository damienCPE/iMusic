package partie3.model;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Track;
import partie1.model.Musique;
import partie3.serveur.IService;

public class MusiqueFichierServer extends Musique {
	String chemin;
	private IService stub;

	public MusiqueFichierServer(String s) {
		this.chemin = s;
		IService stub;
		try {
			// Initialisation du registry sur le port 1099
			Registry registry = LocateRegistry.getRegistry(1099);

			// Récupération du stub lié au serveur
			this.stub = (IService) registry.lookup("MusicService");
		} catch (Exception e) {

		}

	}

	@Override
	public int creationPiste() {
		// creer une sequence et une piste
		try {
			chemin = this.stub.getInformation();
			this.setSeq(MidiSystem.getSequence(new File(chemin)));
		} catch (Exception e) {
			return -1;
		}

		// Sequence seq = new Sequence(Sequence.PPQ, 4);
		Track piste = this.getSeq().createTrack();

		return 0;
	}

}
