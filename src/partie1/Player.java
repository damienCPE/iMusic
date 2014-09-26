package partie1;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Player {
	private Sequencer mySequencer;
	
	public Sequencer getMySequence() {
		return mySequencer;
	}

	public void setMySequence(Sequencer mySequence) {
		this.mySequencer = mySequence;
	}
	
	// lit la musique
	public int lire(){
		if(mySequencer.isOpen()){
			mySequencer.start();
			return 0;
		}
		return -1;
	}
	
	// arrete la musique
	public int stop(){
		if(mySequencer.isRunning()){
			mySequencer.stop();
			return 0;
		}
		return -1;
	}
	
	// charge la sequence de la musique 
	public int charger(Sequence seq){
		try {
			mySequencer.setSequence(seq);
			return 0;
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}
