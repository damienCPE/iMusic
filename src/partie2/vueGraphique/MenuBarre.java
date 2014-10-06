package partie2.vueGraphique;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import partie2.controleur.IHMListener;

public class MenuBarre extends JPanel {

    JButton exit, home, previous, play, pause, stop, next;
    IHMListener il;

    public MenuBarre() {
        exit = new JButton("");
        this.exit.setToolTipText("Quitter iMusic");
        home = new JButton("");
        this.home.setToolTipText("Selectionner un fichier");
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

        this.il = new IHMListener(this);

        this.add(exit);
        this.exit.setIcon(new ImageIcon("./src/images/exit.png"));
        // this.exit.setBounds(0,0,80,80);
        this.exit.addActionListener(il);

        this.add(home);
        this.home.setIcon(new ImageIcon("./src/images/home-copie.png"));
        // this.home.setBounds(100,0,80,80);
        this.home.addActionListener(il);

        this.add(previous);
        this.previous.setIcon(new ImageIcon("./src/images/previous-copie.png"));
        // this.previous.setBounds(800/2-150,0,80,80);
        this.previous.addActionListener(il);
        this.previous.setEnabled(false);

        this.add(play);
        this.play.setIcon(new ImageIcon("./src/images/play-copie.png"));
        // this.play.setBounds(800/2-50,0,80,80);
        this.play.addActionListener(il);

        this.add(pause);
        this.pause.setIcon(new ImageIcon("./src/images/pause-copie.png"));
        // this.pause.setBounds(800/2-50,0,80,80);
        this.pause.addActionListener(il);
        this.pause.setVisible(false);

        this.add(stop);
        this.stop.setIcon(new ImageIcon("./src/images/stop-copie.png"));
        // this.stop.setBounds(800/2+50,0,80,80);
        this.stop.addActionListener(il);

        this.add(next);
        this.next.setIcon(new ImageIcon("./src/images/next-copie.png"));
        // this.next.setBounds(800/2+150,0,80,80);
        this.next.addActionListener(il);
        this.next.setEnabled(false);

    }

    public JButton getHhome() {
        return this.home;
    }

    public JButton getPrevious() {
        return this.previous;
    }

    public JButton getPlay() {
        return this.play;
    }

    public JButton getPause() {
        return this.pause;
    }

    public JButton getStop() {
        return this.stop;
    }

    public JButton getNext() {
        return this.next;
    }

    public JButton getExit() {
        return this.exit;
    }

}
