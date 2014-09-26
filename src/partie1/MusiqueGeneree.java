package partie1;

import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class MusiqueGeneree extends Musique {

	@Override
	public int creationPiste() {
		/*
         * Le processus comprend 5 �tapes
         * 1 - Obtenir un s�quenceur, un objet Sequencer, et l�ouvrir
         * 2 - Cr�er un nouvel objet Sequence
         * 3 - Demander � la Sequence de cr�er une piste piste de type Track
         * 4 - Remplir la piste d��v�nements MIDI � MidiEvents � et transmettre la s�quence au s�quenceur
         * 5 - D�marrer le s�quenceur avec la m�thode start() 
         */

        try {
            // cr�er une s�quence et une piste
            this.setSeq(new Sequence(Sequence.PPQ, 4));
            //Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track piste = this.getSeq().createTrack();

            // maintenant cr�er deux �v�nements midi (contenant un message midi)
            int r = 0;
            for (int i = 0; i < 100; i+= 4) {

                r = (int) ((Math.random() * 50) + 1);
                
                // ajouter les �v�nements � la piste
                
                // 144 = noteOn, 1 = piano, 44 = la note, 100 = v�locit�
                piste.add(makeEvent(144,1,r,100,i));
                
                /* Pour suivre le rythme. Nous ins�rons notre PROPRE ControllerEvent :
                 * 176 indique que le type de l'�v�nement est ControllerEvent) 
                 * avec un argument pour le num�ro d'�v�nement, 127. 
                 * Cet �v�nement ne fera RIEN ! 
                 * Il n'est l� QUE pour que nous ayons un �v�nement chaque fois qu'une note est jou�e. 
                 * Autrement dit, sa seule raison d'�tre est qu'un �v�nement se d�clenche 
                 * que NOUS puissions �couter (impossible d'�couter NOTE ON/OFF ). 
                 * Cet �v�nement a lieu sur le M�ME temps que NOTE ON. 
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
    } // fin de la m�thode go()

}
