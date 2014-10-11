package partie3.model;

import javax.sound.midi.InvalidMidiDataException;

import partie1.model.Musique;
import partie1.model.Player;
import partie1.model.TypeMusique;

public class PlayerCS extends Player{
	
	protected Player player;

	public PlayerCS(Player player) {
		super();
		this.player = player;
	}
	
	// Creer la piste audio a partir du fichier passe en parametre et la charge
    // dans le sequenceur
    public int chargerFichierServeur(String fichier) {
        Musique mus;
        this.player.creerSequencer();
        mus = this.player.musFac.creationMusique(TypeMusique.SERVER, fichier);
        if (mus == null){
        	return -1;
        }
            
        mus.creationPiste();
        try {
        	this.player.getMySequence().setSequence(mus.getSeq());
        	this.player.getMySequence().setTempoInBPM(120);
            return 0;
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
