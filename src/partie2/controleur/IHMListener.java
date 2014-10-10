package partie2.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import partie1.controleur.Controlleur;
import partie2.vueGraphique.Fenetre;

public class IHMListener implements ActionListener {

    protected Fenetre f;
    protected Controlleur ctrlr;

    public IHMListener(Fenetre f) {
        super();
        this.f = f;
        this.ctrlr = new Controlleur();
        this.ctrlr.addObserver(this.f.getPetitsCarres().getPetitsCarresObserver());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str;
        if (e.getSource() == f.getMenuBarre().getExitBut()) {
            ctrlr.quitterPlayer();
            System.exit(0);
        }
        if (e.getSource() == f.getMenuBarre().getFileBut()) {
            str = f.getMenuBarre().chargerFichier();
            ctrlr.chargerFichier(str);
        }
        if (e.getSource() == f.getMenuBarre().getGenererBut()) {
            ctrlr.generer();
        }
        if (e.getSource() == f.getMenuBarre().getPreviousBut()) {
            // TODO
        }
        if (e.getSource() == f.getMenuBarre().getPlayBut()) {
            if (ctrlr.DemarrerLecture() == 0) {
                f.getMenuBarre().getPlayBut().setVisible(false);
                f.getMenuBarre().getPauseBut().setVisible(true);
            }
        }
        if (e.getSource() == f.getMenuBarre().getPauseBut()) {
            ctrlr.ArreterLecture();
            f.getMenuBarre().getPauseBut().setVisible(false);
            f.getMenuBarre().getPlayBut().setVisible(true);
        }
        if (e.getSource() == f.getMenuBarre().getStopBut()) {
            ctrlr.ArreterLecture();
            f.getMenuBarre().getPauseBut().setVisible(false);
            f.getMenuBarre().getPlayBut().setVisible(true);
            ctrlr.closeSeq();
        }
        if (e.getSource() == f.getMenuBarre().getSquareToCircle()) {
            f.getMenuBarre().getSquareToCircle().setVisible(false);
            f.getMenuBarre().getCircleToSquare().setVisible(true);
            f.getPetitsCarres().setFigType(false);
        }
        if (e.getSource() == f.getMenuBarre().getCircleToSquare()) {
            f.getMenuBarre().getCircleToSquare().setVisible(false);
            f.getMenuBarre().getSquareToCircle().setVisible(true);
            f.getPetitsCarres().setFigType(true);
        }
    }
}
