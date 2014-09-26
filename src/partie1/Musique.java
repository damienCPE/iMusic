package partie1;

import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class Musique {
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
	
	public Musique() {
		super();
	}
	
	
}
