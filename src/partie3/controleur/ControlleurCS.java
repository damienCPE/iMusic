package partie3.controleur;

import partie1.controleur.Controlleur;
import partie2.controleur.ControlleurDeco;
import partie3.model.PlayerCS;

public class ControlleurCS extends ControlleurDeco {
	protected ControlleurDeco controlleur;
	protected PlayerCS playerCS;
	
	public ControlleurCS() {
		super();
		this.controlleur = super.getControlleurDeco();
		this.playerCS = new PlayerCS(controlleur.getPlayer());
	}
	
	public ControlleurCS(ControlleurDeco ctrl) {
		super();
		this.controlleur = ctrl;
		this.playerCS = new PlayerCS(controlleur.getPlayer());
	}

    public Controlleur getControlleur() {
		return controlleur;
	}

	public void setControlleur(ControlleurDeco controlleur) {
		this.controlleur = controlleur;
	}

	public PlayerCS getPlayercs() {
		return playerCS;
	}

	public void setPlayercs(PlayerCS playercs) {
		this.playerCS = playercs;
	}

	// Charge le fichier midi passer en parametre
    public int chargerFichierServeur(String f) {
    	if(this.playerCS.chargerFichierServeur(f) == -1)
    		return -1;
        
        this.controlleur.setPlayer(playerCS.getPlayer());
        if(this.controlleur.getPlayer().getMySequence() == null)
        	System.out.println("controlleur.getPlayer().getMySequence null");
        this.musList.makeEvent(this.playerCS.getPlayer());
        return 0;
    }
}
