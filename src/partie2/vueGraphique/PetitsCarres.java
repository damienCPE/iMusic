package partie2.vueGraphique;

import java.util.Observer;

import javax.swing.JPanel;

import partie2.model.Figure;

public class PetitsCarres extends JPanel {
    
    Figure FigFact;
    PetitsCarresObserver obs;
    
    public PetitsCarres(){
        super();
        FigFact = new Figure();
        obs = new PetitsCarresObserver();
    }

    public Observer getObserver(){
        return this.obs;
    }
}
