package partie2.vueGraphique;

import java.util.Observable;
import java.util.Observer;

import partie2.model.EnumFigure;
import partie2.model.FigureFactory;

public class PetitsCarresObserver implements Observer {
    
    FigureFactory figFact;
    PetitsCarres pc;
    
    public PetitsCarresObserver(PetitsCarres p){
        super();
        this.pc = p;
        figFact = new FigureFactory();
    }

    @Override
    public void update(Observable o, Object arg) {
        figFact.creationFigure(EnumFigure.CARRE);
        this.pc.repaint();
    }

}
