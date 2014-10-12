package partie1.controleur;

import java.util.Observer;

import partie1.model.Player;
import partie2.model.MusicListener;

public class Controlleur {
    protected Player player;
    protected MusicListener musList;

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
        this.musList = new MusicListener();
    }

    // Lance la lecture
    public int DemarrerLecture() {
        if (player.getMySequence() != null) {
            player.lire();
            return 0;
        } else {
            return 1;
        }
    }

    // Met la lecture en pause
    public void ArreterLecture() {
        if (player.getMySequence() != null) {
            player.stop();
        }
    }

    // Charge le fichier midi passer en parametre
    public int chargerFichier(String f) {
        this.player.chargerFichier(f);
        this.musList.makeEvent(this.player);
        return 0;
    }

    // Quitte le player en fermant tous les elements ouverts
    public int quitterPlayer() {
        if (player.getMySequence() == null)
            return -1;
        if (this.player.getMySequence().isRunning()) {
            ArreterLecture();
        }
        if (this.player.getMySequence().isOpen()) {
            this.player.getMySequence().close();
        } else
            return -2;
        this.player.quitter();
        return 0;
    }

    // Appel la generation par algorithme d'une piste audio
    public int generer() {
        this.player.genererMusique();
        this.musList.makeEvent(this.player);
        return 0;
    }

    public void closeSeq() {
        if (this.player.getMySequence() != null && this.player.getMySequence().isOpen()) {
            this.player.getMySequence().close();
            this.player.setMySequence(null);
        }
    }
    
    public void addObserver(Observer obs){
        this.musList.addObserver(obs);
    }

    public Controlleur getControlleur() {
        return this;
    }
}
