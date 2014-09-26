package partie1;

import java.util.ArrayList;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Player implements Observable{
    private MusiqueFactory musFac;
    private Sequencer mySequencer;
    private ArrayList tabObservateur;// Tableau d'observateurs.
    

    public Player() {
        this.musFac = new MusiqueFactory();
        tabObservateur=new ArrayList();
        //this.creerSequencer();
    }

    public Sequencer getMySequence() {
        return mySequencer;
    }

    public void setMySequence(Sequencer mySequence) {
        this.mySequencer = mySequence;
    }

    public void lire() {
        if (mySequencer.isOpen()) {
            mySequencer.start();
        }
    }

    public void stop() {
        if (mySequencer.isRunning()) {
            mySequencer.stop();
        }
        mySequencer.close();
    }

    public int charger(Sequence seq) {
        try {
            mySequencer.setSequence(seq);
            return 0;
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public int quitter(){
    	mySequencer.close();
    	return 0;
    }

    private void creerSequencer() {
        try {
            this.mySequencer = MidiSystem.getSequencer();
            mySequencer.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

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

    public int genererMusique() {
        Musique mus;
        //this.creerSequencer();
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

	@Override
	public void addListener(InvalidationListener arg0) {
		tabObservateur.add(arg0); 
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		tabObservateur.remove(arg0);
		
	}
}
