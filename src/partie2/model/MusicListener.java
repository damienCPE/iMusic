package partie2.model;

import java.util.Observable;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;

import partie1.model.Player;

public class MusicListener extends Observable implements ControllerEventListener {
    
    public MusicListener (){
        super();
    }
    
    @Override
    public void controlChange(ShortMessage event) {
        setChanged();
        this.notifyObservers();
    }
    
    public void makeEvent(Player p){
        p.getSequencer().addControllerEventListener(this, new int[] {127});
    }
}
