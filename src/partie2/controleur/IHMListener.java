package partie2.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import partie1.controleur.Controlleur;
import partie2.vueGraphique.Fenetre;

public class IHMListener implements ActionListener {

    protected Fenetre f;
    protected ControlleurDeco ctrlrDeco;

    public IHMListener(Fenetre f) {
        super();
        this.f = f;
        this.ctrlrDeco = new ControlleurDeco();
        this.ctrlrDeco.addObserver(this.f.getPetitsCarres().getPetitsCarresObserver());
    }
    
    public ControlleurDeco getctrlrDeco() {
		return ctrlrDeco;
	}

	public void setctrlrDeco(ControlleurDeco ctrlr) {
		this.ctrlrDeco = ctrlr;
	}
	
    /*public void setControlleur(Controlleur c){
        this.ctrlr = c;
    }*/

    public IHMListener getIHMListener() {
        return this;
    }

	@Override
    public void actionPerformed(ActionEvent e) {
        String str;
        if (e.getSource() == f.getMenuBarre().getExitBut()) {
        	ctrlrDeco.quitterPlayer();
            System.exit(0);
        }
        if (e.getSource() == f.getMenuBarre().getFileBut()) {
            str = f.getMenuBarre().chargerFichier();
            ctrlrDeco.chargerFichier(str);
        }
        if (e.getSource() == f.getMenuBarre().getGenererBut()) {
        	ctrlrDeco.generer();
        }
        if (e.getSource() == f.getMenuBarre().getPreviousBut()) {
            // TODO
        }
        if (e.getSource() == f.getMenuBarre().getPlayBut()) {
            if (ctrlrDeco.DemarrerLecture() == 0) {
                f.getMenuBarre().getPlayBut().setVisible(false);
                f.getMenuBarre().getPauseBut().setVisible(true);
            }
        }
        if (e.getSource() == f.getMenuBarre().getPauseBut()) {
        	ctrlrDeco.ArreterLecture();
            f.getMenuBarre().getPauseBut().setVisible(false);
            f.getMenuBarre().getPlayBut().setVisible(true);
        }
        if (e.getSource() == f.getMenuBarre().getStopBut()) {
        	ctrlrDeco.ArreterLecture();
            f.getMenuBarre().getPauseBut().setVisible(false);
            f.getMenuBarre().getPlayBut().setVisible(true);
            ctrlrDeco.closeSeq();
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
