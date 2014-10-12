package partie1.model;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

import partie2.model.MusicListener;

public class Player {
    protected MusiqueFactory musFac;
    protected Sequencer mySequencer;

    // Constructeur
    public Player() {
        this.musFac = new MusiqueFactory();
    }

    // Getter de l'attribut mySequence
    public Sequencer getMySequence() {
    	if(mySequencer == null)
    		System.out.println("getSequencer null");
        return mySequencer;
    }

    // Setter de l'attribut mySequence
    public void setMySequence(Sequencer mySequence) {
        this.mySequencer = mySequence;
    }
    
    // Getter de l'attribut musFac
    public MusiqueFactory getMusFac() {
		return musFac;
	}

    // Setter de l'attribut musFac
	public void setMusFac(MusiqueFactory musFac) {
		this.musFac = musFac;
	}

	// Lance la lecture du fichier si le sequenceur est ouvert
    public void lire() {
        if (mySequencer.isOpen()) {
            mySequencer.start();
        }
    }

    // Arrete la lecture si le sequenceur est fermee
    public void stop() {
        if (mySequencer.isRunning()) {
            mySequencer.stop();
        }
    }

    // Charge la sequence dans le sequenceur
    public int charger(Sequence seq) {
        try {
            mySequencer.setSequence(seq);
            return 0;
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Ferme le sequenceur
    public int quitter() {
        mySequencer.close();
        return 0;
    }

    // Creer le sequenceur
    public void creerSequencer() {
        try {
            this.mySequencer = MidiSystem.getSequencer();
            mySequencer.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Accesseur du sequenceur
    /*public Sequencer getSequencer() {
        return this.mySequencer;
    }*/

    // Creer la piste audio a partir du fichier passe en parametre et la charge
    // dans le sequenceur
    public int chargerFichier(String fichier) {
        Musique mus;
        this.creerSequencer();
        mus = this.musFac.creationMusique(TypeMusique.FICHIER, fichier);
        if (mus == null)
            return -1;
        mus.creationPiste();
        try {
            mySequencer.setSequence(mus.getSeq());
            mySequencer.setTempoInBPM(120);
            return 0;
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Creer la piste audio a partir d'un algorithme et la charge dans le
    // sequenceur
    public int genererMusique() {
        Musique mus;
        this.creerSequencer();
        mus = this.musFac.creationMusique(TypeMusique.GENEREE, "");
        if (mus == null)
            return -1;
        mus.creationPiste();
        try {
            mySequencer.setSequence(mus.getSeq());
            return 0;
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void addControllerEventListener(MusicListener musicListener) {
        // TODO Auto-generated method stub
    	if(musicListener == null)
    		System.out.println("musicListener null");
    	if(this.mySequencer == null)
    		System.out.println("mySequencer null");
        this.mySequencer.addControllerEventListener(musicListener, new int[] {127});
    }
}
