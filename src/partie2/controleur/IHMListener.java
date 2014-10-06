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
        String str;
        if(e.getSource() == mb.getExitBut()) {
            ctrlr.quitterPlayer();
            System.exit(0);
        }
        if(e.getSource() == mb.getFileBut()) {
            str = mb.chargerFichier();
            ctrlr.chargerFichier(str);
        }
        if(e.getSource() == mb.getGenererBut()) {
            ctrlr.generer();
        }
        if(e.getSource() == mb.getPreviousBut()) {
            //TODO
        }
        if(e.getSource() == mb.getPlayBut()) {
            if(ctrlr.DemarrerLecture() == 0){
                mb.getPlayBut().setVisible(false);
                mb.getPauseBut().setVisible(true);
            }
        }
        if(e.getSource() == mb.getPauseBut()) {
            ctrlr.ArreterLecture();
            mb.getPauseBut().setVisible(false);
            mb.getPlayBut().setVisible(true);
        }
        if(e.getSource() == mb.getStopBut()) {
            ctrlr.ArreterLecture();
            mb.getPauseBut().setVisible(false);
            mb.getPlayBut().setVisible(true);
            ctrlr.closeSeq();
        }
    }
}
