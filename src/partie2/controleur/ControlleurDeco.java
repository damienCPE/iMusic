package partie2.controleur;

import java.util.Observer;

import partie1.controleur.Controlleur;
import partie2.model.MusicListener;
import partie3.model.PlayerCS;

public class ControlleurDeco extends Controlleur {
	protected Controlleur controlleur;
	protected PlayerCS playercs;
	protected MusicListener musList;
	
	public ControlleurDeco() {
		super();
		this.controlleur = super.getControlleur();
		if(controlleur == null){
			controlleur = new Controlleur();
			System.out.println("bsivs");
		}
		this.musList = new MusicListener();
		this.playercs = new PlayerCS(controlleur.getPlayer());
	}
	
	public ControlleurDeco(Controlleur ctrl) {
		super();
		this.controlleur = ctrl;
		this.playercs = new PlayerCS(controlleur.getPlayer());
		this.musList = new MusicListener();
	}

    public Controlleur getControlleur() {
		return controlleur;
	}

	public void setControlleur(Controlleur controlleur) {
		this.controlleur = controlleur;
	}

	public PlayerCS getPlayercs() {
		return playercs;
	}

	public void setPlayercs(PlayerCS playercs) {
		this.playercs = playercs;
	}

	public MusicListener getMusList() {
		return musList;
	}

	public void setMusList(MusicListener musList) {
		this.musList = musList;
	}
	
	// Charge le fichier midi passer en parametre
    public int chargerFichier(String f) {
        super.chargerFichier(f);
        this.musList.makeEvent(this.player);
        return 0;
    }
    
    // Appel la generation par algorithme d'une piste audio
    public int generer() {
        super.generer();
        this.musList.makeEvent(this.player);
        return 0;
    }
    
    public void addObserver(Observer obs){
    	if(this == null)
    		System.out.println("null");
    	if(this.musList == null)
    		System.out.println("null musList");
        this.musList.addObserver(obs);
    }
    
    public ControlleurDeco getControlleurDeco() {
        return this;
    }
	
}
