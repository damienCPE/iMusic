package partie1.controleur;

import partie1.model.Player;

public class Controlleur {
	private Player player;
	
	// Getter de l'attribut player
	public Player getPlayer() {
		return player;
	}

	// Setter de l'attribut player
	public void setPlayer(Player player) {
		this.player = player;
	}

	// Controlleur
	public Controlleur() {
		super();
		this.player = new Player();
	}

	// Lance la lecture
	public void DemarrerLecture(){
		if(player.getMySequence() != null){
			player.lire();
		}
	}
	
	// Met la lecture en pause
	public void ArreterLecture(){
		if(player.getMySequence() != null){
			player.stop();
		}
	}
    
	// Charge le fichier midi passer en parametre
    public int chargerFichier(String f){
        this.player.chargerFichier(f);
        return 0;
    }
    
    // Quitte le player en fermant tous les elements ouverts
    public int quitterPlayer(){
    	if(player.getMySequence() == null)
    		return -1;
    	if(this.player.getMySequence().isRunning()){
    		ArreterLecture();
    	}
    	if(this.player.getMySequence().isOpen()){
    		this.player.getMySequence().close();
    	}else
    		return -2;
    	this.player.quitter();
    	return 0;
    }
    
    // Appel la generation par algorithme d'une piste audio
    public int generer(){
        this.player.genererMusique();
        return 0;
    }
}
