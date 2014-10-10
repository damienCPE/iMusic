package partie3.vue;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import partie2.vueGraphique.Fenetre;
import partie2.vueGraphique.MenuBarre;
import partie3.controleur.IHMListenerCS;

public class MenuBarreCS extends MenuBarre {
    
    protected MenuBarre mb;
    protected IHMListenerCS ilcs;
    protected JButton serveur;
    
    public MenuBarreCS(Fenetre f, FenetreCS fcs) {
        super(f);
        mb = f.getMenuBarre();
        
        //Creation listener
        this.ilcs = new IHMListenerCS(f, fcs);
        
        //Ajout du nouveau bouton
        this.serveur = new JButton("");
        this.serveur.setToolTipText("Telecharger un fichier du serveur");
        this.mb.add(this.serveur);
        this.serveur.setIcon(new ImageIcon("./src/images/serveur.png"));
        this.serveur.addActionListener(this.ilcs);
        this.serveur.setVisible(true);
    }

    public JButton getButServeur(){
        return this.serveur;
    }
}
