package partie1.model;

import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MusiqueGeneree extends Musique {

	@Override
	// Genere la piste audio a partir d'un "algorithme"
	public int creationPiste() {
		/*
         * Le processus comprend 5 etapes
         * 1 - Obtenir un sequenceur, un objet Sequencer, et leouvrir
         * 2 - Creer un nouvel objet Sequence
         * 3 - Demander e la Sequence de creer une piste piste de type Track
         * 4 - Remplir la piste deevenements MIDI e MidiEvents e et transmettre la sequence au sequenceur
         * 5 - Demarrer le sequenceur avec la methode start() 
         */

        try {
            // creer une sequence et une piste
        	
            this.setSeq(new Sequence(Sequence.PPQ, 4));
            this.setPiste(this.getSeq().createTrack());

            // maintenant creer deux evenements midi (contenant un message midi)
            int r = 0;
            for (int i = 0; i < 100; i+= 4) {

                r = (int) ((Math.random() * 50) + 1);
                
                // ajouter les evenements de la piste
                
                // 144 = noteOn, 1 = piano, 44 = la note, 100 = velocite
                this.getPiste().add(makeEvent(144,1,r,100,i));
                
                /* Pour suivre le rythme. Nous inserons notre PROPRE ControllerEvent :
                 * 176 indique que le type de l'evenement est ControllerEvent) 
                 * avec un argument pour le numero d'evenement, 127. 
                 * Cet evenement ne fera RIEN ! 
                 * Il n'est le QUE pour que nous ayons un evenement chaque fois qu'une note est jouee. 
                 * Autrement dit, sa seule raison d'etre est qu'un evenement se declenche 
                 * que NOUS puissions ecouter (impossible d'ecouter NOTE ON/OFF ). 
                 * Cet evenement a lieu sur le MeME temps que NOTE ON. 
                 */
                this.getPiste().add(makeEvent(176,1,127,0,i));
                
                // 128 = noteOff                
                this.getPiste().add(makeEvent(128,1,r,100,i + 2));
                
            }
            
            return 0;
        } catch (Exception ex) {
        	ex.printStackTrace();
        	return -1;	
        }
    }

}
