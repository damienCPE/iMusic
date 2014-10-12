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
	protected String chemin;
	protected IService stub;

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public IService getStub() {
		return stub;
	}

	public void setStub(IService stub) {
		this.stub = stub;
	}

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
			System.out.println(chemin);
			this.setSeq(MidiSystem.getSequence(new ByteArrayInputStream(bytes)));
		} catch (Exception e) {
			return -1;
		}

		// Sequence seq = new Sequence(Sequence.PPQ, 4);
		Track piste = this.getSeq().createTrack();

		return 0;
	}

}
