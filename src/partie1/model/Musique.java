package partie1.model;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public abstract class Musique implements IMusique{
	private Sequence seq;
	private Track piste;
	
	// Getter de l'attribut sequence
	public Sequence getSeq() {
		return seq;
	}
	
    // Setter de l'attribut sequence
	public void setSeq(Sequence seq) {
		this.seq = seq;
	}
	
    // Getter de l'attribut piste
	public Track getPiste() {
		return piste;
	}
	
	//Setter de l'attribut piste
	public void setPiste(Track piste) {
		this.piste = piste;
	}
	
	// Creer des evenements sur la piste audio
	// Si comd = 127, cette fonction ne fais rien
	 public MidiEvent makeEvent(int comd, int can, int un, int deux, int tic) {
        MidiEvent evenement = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, can, un, deux);
            evenement = new MidiEvent(a, tic);

        }catch(Exception e) { }
        return evenement;
    }
	
}
