package partie2.vueGraphique;

import java.awt.Graphics;
import java.util.Observer;

import javax.swing.JPanel;

import partie2.model.EnumFigure;
import partie2.model.FigureFactory;

public class PetitsCarres extends JPanel {

    FigureFactory figFact;
    PetitsCarresObserver obs;
    public boolean event = false;

    public PetitsCarres() {
        super();
        figFact = new FigureFactory();
        obs = new PetitsCarresObserver(this);
    }

    public Observer getPetitsCarresObserver() {
        return this.obs;
    }

    public void paintComponent(Graphics g) {
        if (this.event == true) {
            figFact.creationFigure(EnumFigure.CARRE, g, this.getHeight(),
                    this.getWidth());
            this.event = false;
        }
    }
}
