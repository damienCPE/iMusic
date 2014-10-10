package partie3.controleur;

import partie1.controleur.Controlleur;
import partie3.model.PlayerCS;

public class ControlleurCS extends Controlleur {
	protected Controlleur controlleur;
	protected PlayerCS playercs;
	
	public ControlleurCS() {
		super();
		this.controlleur = new Controlleur();
		this.playercs = new PlayerCS();
	}
	
    // Charge le fichier midi passer en parametre
    public int chargerFichierServeur(String f) {
        this.playercs.chargerFichier(f);
        this.musList.makeEvent(this.playercs);
        return 0;
    }
}
