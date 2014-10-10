package partie3.model;

import java.io.ByteArrayInputStream;
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
			Registry registry = LocateRegistry.getRegistry(1099);

			this.stub = (IService) registry.lookup("MusicService");
		} catch (Exception e) {

		}

	}

	@Override
	public int creationPiste() {
		try {
			byte[] bytes = this.stub.getInformation(chemin);
			this.setSeq(MidiSystem.getSequence(new ByteArrayInputStream(bytes)));
		} catch (Exception e) {
			return -1;
		}

		// Sequence seq = new Sequence(Sequence.PPQ, 4);
		Track piste = this.getSeq().createTrack();

		return 0;
	}

}
