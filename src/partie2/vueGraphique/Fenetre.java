package partie2.vueGraphique;

import java.awt.Color;

import javax.swing.JFrame;

public class Fenetre extends JFrame {

    MenuBarre mb;
    PetitsCarres pc;

    public Fenetre() {
        super();

        this.setTitle("IMusic v2.0");
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);

        this.mb = new MenuBarre();
        this.add(mb);
        mb.setBounds(0, 0, 1200, 120);
        this.pc = new PetitsCarres();
        pc.setBounds(0, 120, 1200, 680);
        this.add(pc);

        this.setVisible(true);
    }
}
