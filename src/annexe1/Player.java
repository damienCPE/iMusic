package annexe1;

import javax.sound.midi.Sequencer;

public class Player {
	private Sequencer mySequence;
	
	public Sequencer getMySequence() {
		return mySequence;
	}

	public void setMySequence(Sequencer mySequence) {
		this.mySequence = mySequence;
	}
	
	public void lire(){
		if(mySequence.isOpen()){
			mySequence.start();
		}
	}
	
	public void stop(){
		if(mySequence.isRunning()){
			mySequence.stop();
		}
	}
	
	public void load(){
		
	}
	
}
