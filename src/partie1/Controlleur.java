package partie1;

public class Controlleur {
	private Player player;
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Controlleur() {
		super();
		this.player = new Player();
	}

	public void DemarrerLecture(){
		if(player.getMySequence() != null){
			player.lire();
		}
	}
	
	public void ArreterLecture(){
		if(player.getMySequence() != null){
			player.stop();
		}
	}
    
    public int chargerFichier(String f){
        this.player.chargerFichier(f);
        return 0;
    }
    
    public int generer(String f){
        this.player.genererMusique();
        return 0;
    }
}
