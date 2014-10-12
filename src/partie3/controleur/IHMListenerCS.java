package partie3.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import partie2.controleur.IHMListener;
import partie2.vueGraphique.Fenetre;
import partie3.vue.FenetreCS;
import partie3.vue.MenuBarreCS;

public class IHMListenerCS extends IHMListener implements ActionListener {

    protected FenetreCS fcs;
    protected ControlleurCS ctrlrcs;

    public IHMListenerCS(Fenetre f, FenetreCS fcs) {
        super(f);
        this.fcs = fcs;
        this.ctrlrcs = new ControlleurCS();
        this.ctrlr = ctrlrcs.getControlleur();
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
