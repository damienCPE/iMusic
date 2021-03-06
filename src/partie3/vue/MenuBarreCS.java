package partie3.vue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import partie2.vueGraphique.Fenetre;
import partie2.vueGraphique.MenuBarre;
import partie3.controleur.IHMListenerCS;

public class MenuBarreCS extends MenuBarre {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected MenuBarre mb;
    protected IHMListenerCS ilcs;
    protected JButton serveur;
    
    public MenuBarreCS(Fenetre f, FenetreCS fcs) {
        super(f);
        mb = f.getMenuBarre();
        
        //Creation listener
        this.ilcs = new IHMListenerCS(f, fcs, mb.getIl());
        
        //MAJ listener de la MenuBarre
        this.mb.setIHMListener(this.ilcs.getIHMListener());
        
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

	public MenuBarre getMb() {
		return mb;
	}

	public void setMb(MenuBarre mb) {
		this.mb = mb;
	}

	public IHMListenerCS getIlcs() {
		return ilcs;
	}

	public void setIlcs(IHMListenerCS ilcs) {
		this.ilcs = ilcs;
	}

	public JButton getServeur() {
		return serveur;
	}

	public void setServeur(JButton serveur) {
		this.serveur = serveur;
	}
    
    
}
