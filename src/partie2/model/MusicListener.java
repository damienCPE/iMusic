package partie2.model;

import java.util.Observable;

import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;

import partie1.model.Player;

public class MusicListener extends Observable implements ControllerEventListener {

    Player pl;
    
    public MusicListener (Player p){
        super();
        this.pl = p;
    }
    
    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("Test");
    }
    
    public void makeEvent(){
        this.pl.getSequencer().addControllerEventListener(this, new int[] {127});
    }
}
