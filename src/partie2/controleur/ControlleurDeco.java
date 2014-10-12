package partie2.controleur;

import java.util.Observer;

import partie1.controleur.Controlleur;
import partie2.model.MusicListener;

public class ControlleurDeco extends Controlleur {
	protected Controlleur controlleur;
	protected MusicListener musList;
	
	public ControlleurDeco() {
		super();
		this.controlleur = super.getControlleur();
		if(controlleur == null){
			controlleur = new Controlleur();
		}
		this.musList = new MusicListener();
	}
	
	public ControlleurDeco(Controlleur ctrl) {
		super();
		this.controlleur = ctrl;
		this.musList = new MusicListener();
	}

    public Controlleur getControlleur() {
		return controlleur;
	}

	public void setControlleur(Controlleur controlleur) {
		this.controlleur = controlleur;
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
        this.musList.addObserver(obs);
    }
    
    public ControlleurDeco getControlleurDeco() {
        return this;
    }
	
}
