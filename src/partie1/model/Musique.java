package partie1.model;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import partie2.model.MusicListener;

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
        this.createEvents();
	}
	
	public void createEvents(){
	 // maintenant creer deux evenements midi (contenant un message midi)
        int r = 0;
        for (int i = 0; i < 100; i+= 4) {

            r = (int) ((Math.random() * 50) + 1);
            
            // ajouter les evenements à la piste
            
            // 144 = noteOn, 1 = piano, 44 = la note, 100 = velocite
            this.piste.add(makeEvent(144,1,r,100,i));
            
            /* Pour suivre le rythme. Nous inserons notre PROPRE ControllerEvent :
             * 176 indique que le type de l'evenement est ControllerEvent) 
             * avec un argument pour le numero d'evenement, 127. 
             * Cet evenement ne fera RIEN ! 
             * Il n'est là QUE pour que nous ayons un evenement chaque fois qu'une note est jouee. 
             * Autrement dit, sa seule raison d'etre est qu'un evenement se declenche 
             * que NOUS puissions ecouter (impossible d'ecouter NOTE ON/OFF ). 
             * Cet evenement a lieu sur le MeME temps que NOTE ON. 
             */
            this.piste.add(makeEvent(176,1,127,0,i));
            
            // 128 = noteOff                
            this.piste.add(makeEvent(128,1,r,100,i + 2));
            
        } // fin de la boucle
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
