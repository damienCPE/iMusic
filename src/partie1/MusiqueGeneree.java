package partie1;

import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MusiqueGeneree extends Musique {

	@Override
	public int creationPiste() {
		/*
         * Le processus comprend 5 étapes
         * 1 - Obtenir un séquenceur, un objet Sequencer, et l’ouvrir
         * 2 - Créer un nouvel objet Sequence
         * 3 - Demander à la Sequence de créer une piste piste de type Track
         * 4 - Remplir la piste d’événements MIDI — MidiEvents — et transmettre la séquence au séquenceur
         * 5 - Démarrer le séquenceur avec la méthode start() 
         */

        try {
            // créer une séquence et une piste
            this.setSeq(new Sequence(Sequence.PPQ, 4));
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
                
            } // fin de la boucle
            
            return 0;
        } catch (Exception ex) {
        	ex.printStackTrace();
        	return -1;	
        }
    } // fin de la méthode go()

}
