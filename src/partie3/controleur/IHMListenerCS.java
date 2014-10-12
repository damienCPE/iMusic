package partie3.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import partie2.controleur.IHMListener;
import partie2.vueGraphique.Fenetre;
import partie3.vue.FenetreCS;

public class IHMListenerCS extends IHMListener implements ActionListener {

	protected IHMListener IhmListener;
    protected FenetreCS fcs;
    protected ControlleurCS ctrlrcs;

    public IHMListenerCS(Fenetre f, FenetreCS fcs, IHMListener il) {
        super(f);
        this.fcs = fcs;
        this.IhmListener = il;
        this.ctrlrcs = new ControlleurCS(this.IhmListener.getCtrlr());
        this.ctrlr = ctrlrcs.getControlleur();
    }

    public ControlleurCS getCtrlrcs() {
		return ctrlrcs;
	}

	public void setCtrlrcs(ControlleurCS ctrlrcs) {
		this.ctrlrcs = ctrlrcs;
	}
	
	public IHMListener getIhmListener() {
		return IhmListener;
	}

	public void setIhmListener(IHMListener ihmListener) {
		IhmListener = ihmListener;
	}

	public FenetreCS getFcs() {
		return fcs;
	}

	public void setFcs(FenetreCS fcs) {
		this.fcs = fcs;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        String str;
        if (e.getSource() == this.fcs.getMenuBarreCS().getButServeur()) {
            //Affichage de la popup de selection de fichier
            str = this.fcs.getMenuBarre().chargerFichier();
            // Chargement du fichier
            ctrlrcs.chargerFichierServeur(str);
        }
    }
}
