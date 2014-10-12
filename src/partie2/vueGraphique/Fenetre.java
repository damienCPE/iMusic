package partie2.vueGraphique;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MenuBarre menuBarre;
    private PetitsCarres petitsCarres;

    public Fenetre() {
        super();

        this.setTitle("IMusic v2.0");
        this.setSize(1400, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        this.petitsCarres = new PetitsCarres();
        this.menuBarre = new MenuBarre(this);
        this.add(menuBarre);
        menuBarre.setBounds(0, 0, this.getWidth(), 120);
        this.add(petitsCarres);
        petitsCarres.setBounds(0, 120, this.getWidth(), 680);

        this.setVisible(true);
    }

	public MenuBarre getMenuBarre() {
		return menuBarre;
	}

	public void setMenuBarre(MenuBarre mb) {
		this.menuBarre = mb;
	}

	public PetitsCarres getPetitsCarres() {
		return petitsCarres;
	}

	public void setPetitsCarres(PetitsCarres pc) {
		this.petitsCarres = pc;
	}
    
    
}
