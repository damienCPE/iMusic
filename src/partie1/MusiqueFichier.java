package partie1;

import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MusiqueFichier extends Musique {

	@Override
	public int creationPiste() {
		// TODO Auto-generated method stub
		// créer une séquence et une piste
		try {
			this.setSeq(MidiSystem.getSequence(new File("./src/annexe1/one_republic-love_runs_out.mid")));
		} catch (Exception e) {
			return -1;
		}
        
        //Sequence seq = new Sequence(Sequence.PPQ, 4);
        Track piste = this.getSeq().createTrack();

        // maintenant créer deux événements midi (contenant un message midi)
        int r = 0;
        for (int i = 0; i < 100; i+= 4) {

            r = (int) ((Math.random() * 50) + 1);
            
            // ajouter les événements à la piste
            
            // 144 = noteOn, 1 = piano, 44 = la note, 100 = vélocité
            piste.add(makeEvent(144,1,r,100,i));
            
            /* Pour suivre le rythme. Nous insérons notre PROPRE ControllerEvent :
             * 176 indique que le type de l'événement est ControllerEvent) 
             * avec un argument pour le numéro d'événement, 127. 
             * Cet événement ne fera RIEN ! 
             * Il n'est là QUE pour que nous ayons un événement chaque fois qu'une note est jouée. 
             * Autrement dit, sa seule raison d'être est qu'un évènement se déclenche 
             * que NOUS puissions écouter (impossible d'écouter NOTE ON/OFF ). 
             * Cet événement a lieu sur le MÊME temps que NOTE ON. 
             */
            piste.add(makeEvent(176,1,127,0,i));
            
            // 128 = noteOff                
            piste.add(makeEvent(128,1,r,100,i + 2));
            
        } // fin de la boucle$
        
        return 0;
	}

}
