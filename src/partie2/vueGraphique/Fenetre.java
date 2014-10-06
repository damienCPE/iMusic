package partie2.vueGraphique;

import java.util.Observer;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

    private MenuBarre mb;
    private PetitsCarres pc;

    public Fenetre() {
        super();

        this.setTitle("IMusic v2.0");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        this.pc = new PetitsCarres();
        this.mb = new MenuBarre(this);
        this.add(mb);
        mb.setBounds(0, 0, 1200, 120);
        this.add(pc);
        pc.setBounds(0, 120, 1200, 680);

        this.setVisible(true);
    }
    
    public MenuBarre getMenuBarre() {
        return this.mb;
    }

    public PetitsCarres getPetitsCarres() {
        return this.pc;
    }
}
