package partie2.vueGraphique;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import partie2.controleur.IHMListener;

public class MenuBarre extends JPanel {

    JButton exit, file, generer, previous, play, pause, stop, next;
    IHMListener il;
    JFileChooser chooser;

    public MenuBarre(Fenetre f) {
         this.setBackground(Color.WHITE);
        
        exit = new JButton("");
        this.exit.setToolTipText("Quitter iMusic");
        file = new JButton("");
        this.file.setToolTipText("Selectionner un fichier");
        generer = new JButton("");
        this.generer.setToolTipText("Genere une piste audio");
        previous = new JButton("");
        this.previous.setToolTipText("Piste precedente");
        play = new JButton("");
        this.play.setToolTipText("Demarrer la lecture");
        pause = new JButton("");
        this.pause.setToolTipText("Mettre la lecture en pause");
        stop = new JButton("");
        this.stop.setToolTipText("Arreter la lecture");
        next = new JButton("");
        this.next.setToolTipText("Piste suivante");

        this.il = new IHMListener(f);
        
        //Création du JFileChooser
        chooser = new JFileChooser("./src/audio");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Fichier audio MIDI", "mid");
        chooser.setFileFilter(filter);

        this.add(exit);
        this.exit.setIcon(new ImageIcon("./src/images/exit"
                + ".png"));
        this.exit.addActionListener(il);

        this.add(file);
        this.file.setIcon(new ImageIcon("./src/images/file.png"));
        this.file.addActionListener(il);

        this.add(generer);
        this.generer.setIcon(new ImageIcon("./src/images/generer.png"));
        this.generer.addActionListener(il);

        this.add(previous);
        this.previous.setIcon(new ImageIcon("./src/images/previous.png"));
        this.previous.addActionListener(il);
        this.previous.setEnabled(false);

        this.add(play);
        this.play.setIcon(new ImageIcon("./src/images/play.png"));
        this.play.addActionListener(il);

        this.add(pause);
        this.pause.setIcon(new ImageIcon("./src/images/pause.png"));
        this.pause.addActionListener(il);
        this.pause.setVisible(false);

        this.add(stop);
        this.stop.setIcon(new ImageIcon("./src/images/stop.png"));
        this.stop.addActionListener(il);

        this.add(next);
        this.next.setIcon(new ImageIcon("./src/images/next.png"));
        this.next.addActionListener(il);
        this.next.setEnabled(false);

    }

    public JButton getFileBut() {
        return this.file;
    }

    public JButton getGenererBut() {
        return this.generer;
    }

    public JButton getPreviousBut() {
        return this.previous;
    }

    public JButton getPlayBut() {
        return this.play;
    }

    public JButton getPauseBut() {
        return this.pause;
    }

    public JButton getStopBut() {
        return this.stop;
    }

    public JButton getNextBut() {
        return this.next;
    }

    public JButton getExitBut() {
        return this.exit;
    }

    // ouvre une fenetre et recupere le chemin du fichier midi selectionne
    public String chargerFichier() {
        String path = "";
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            if(path != ""){
                return path;
            }
        }
        return "";
    }
}
