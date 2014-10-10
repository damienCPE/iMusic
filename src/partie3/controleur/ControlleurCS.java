package partie3.controleur;

import partie1.controleur.Controlleur;

public class ControlleurCS extends Controlleur {
	protected Controlleur controlleur;

	public ControlleurCS() {
		super();
		this.controlleur = new Controlleur();
	}
	
    // Charge le fichier midi passer en parametre
    public int chargerFichier(String f) {
        this.player.chargerFichier(f);
        this.musList.makeEvent(this.player);
        return 0;
    }
}
