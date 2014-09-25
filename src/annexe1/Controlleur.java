package annexe1;

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
		if(player.getMySequence().isRunning()){
			player.lire();
		}
	}
	
	public void ArreterLecture(){
		if(player.getMySequence().isOpen()){
			player.stop();
		}
	}
}
