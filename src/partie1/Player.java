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
	
	public void lire(){
		if(mySequencer.isOpen()){
			mySequencer.start();
		}
	}
	
	public void stop(){
		if(mySequencer.isRunning()){
			mySequencer.stop();
		}
	}
	
	public int charger(Sequence seq){
		try {
			mySequencer.setSequence(seq);
			return 0;
		} catch (InvalidMidiDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
}
