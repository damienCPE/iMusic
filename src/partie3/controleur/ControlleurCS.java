package partie3.controleur;

import partie1.controleur.Controlleur;
import partie3.model.PlayerCS;

public class ControlleurCS extends Controlleur {
	protected Controlleur controlleur;
	protected PlayerCS playercs;
	
	public ControlleurCS() {
		super();
		this.controlleur = super.getControlleur();
		this.playercs = new PlayerCS(controlleur.getPlayer());
	}
	
    // Charge le fichier midi passer en parametre
    public int chargerFichierServeur(String f) {
        this.playercs.chargerFichierServeur(f);
        this.controlleur.setPlayer(playercs.getPlayer());
        if(this.controlleur.getPlayer().getMySequence() == null)
        	System.out.println("controlleur.getPlayer().getMySequence null");
        this.musList.makeEvent(this.playercs.getPlayer());
        return 0;
    }
}
