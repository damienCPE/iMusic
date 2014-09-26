package partie1;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MusiqueFichier extends Musique {

    String chemin;
    
    public MusiqueFichier(String s){
        this.chemin=s;
    }
    
	@Override
	public int creationPiste() {
		// cr�er une s�quence et une piste
		try {
			this.setSeq(MidiSystem.getSequence(new File(chemin)));
		} catch (Exception e) {
			return -1;
		}
        
        //Sequence seq = new Sequence(Sequence.PPQ, 4);
        Track piste = this.getSeq().createTrack();

        // maintenant creer deux evenements midi (contenant un message midi)
        int r = 0;
        for (int i = 0; i < 100; i+= 4) {

            r = (int) ((Math.random() * 50) + 1);
            
            // ajouter les evenements e la piste
            
            // 144 = noteOn, 1 = piano, 44 = la note, 100 = velocite
            piste.add(makeEvent(144,1,r,100,i));
            
            /* Pour suivre le rythme. Nous inserons notre PROPRE ControllerEvent :
             * 176 indique que le type de l'evenement est ControllerEvent) 
             * avec un argument pour le numero d'evenement, 127. 
             * Cet evenement ne fera RIEN ! 
             * Il n'est le QUE pour que nous ayons un evenement chaque fois qu'une note est jouee. 
             * Autrement dit, sa seule raison d'etre est qu'un evenement se declenche 
             * que NOUS puissions ecouter (impossible d'ecouter NOTE ON/OFF ). 
             * Cet evenement a lieu sur le MeME temps que NOTE ON. 
             */
            piste.add(makeEvent(176,1,127,0,i));
            
            // 128 = noteOff                
            piste.add(makeEvent(128,1,r,100,i + 2));
            
        } // fin de la boucle$
        
        return 0;
	}

}
