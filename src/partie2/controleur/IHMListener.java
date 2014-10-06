package partie2.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import partie1.controleur.Controlleur;
import partie2.vueGraphique.MenuBarre;

public class IHMListener implements ActionListener {

    MenuBarre mb;
    Controlleur ctrlr;

    public IHMListener(MenuBarre p) {
        super();
        this.mb = p;
        this.ctrlr = new Controlleur();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //exit, home, previous, play, pause, stop, next
        if(e.getSource() == mb.getExit()) {
            ctrlr.quitterPlayer();
            System.exit(0);
        }
        if(e.getSource() == mb.getPlay()) {
            ctrlr.DemarrerLecture();
        }
        if(e.getSource() == mb.getPlay()) {
            ctrlr.DemarrerLecture();
        }
        if(e.getSource() == mb.getPlay()) {
            ctrlr.DemarrerLecture();
        }
        if(e.getSource() == mb.getPlay()) {
            ctrlr.DemarrerLecture();
        }
        if(e.getSource() == mb.getPlay()) {
            ctrlr.DemarrerLecture();
        }
        if(e.getSource() == mb.getPlay()) {
            ctrlr.DemarrerLecture();
        }
    }
}
