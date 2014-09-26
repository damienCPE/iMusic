package partie1;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public abstract class Musique implements IMusique{
	private Sequence seq;
	private Track piste;
	
	public Sequence getSeq() {
		return seq;
	}
	
	public void setSeq(Sequence seq) {
		this.seq = seq;
	}
	
	public Track getPiste() {
		return piste;
	}
	
	public void setPiste(Track piste) {
		this.piste = piste;
	}
	
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
