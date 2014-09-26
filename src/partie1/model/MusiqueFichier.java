package partie1.model;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MusiqueFichier extends Musique {

    String chemin;
    
    // Constructeur
    public MusiqueFichier(String s){
        this.chemin=s;
    }
    
	@Override
	// Creer la piste audio
	public int creationPiste() {
		// creer une sequence et une piste
		try {
			this.setSeq(MidiSystem.getSequence(new File(chemin)));
		} catch (Exception e) {
			return -1;
		}
        
        //Sequence seq = new Sequence(Sequence.PPQ, 4);
        Track piste = this.getSeq().createTrack();
        
        return 0;
	}

}
