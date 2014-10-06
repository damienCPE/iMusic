package partie2.vueGraphique;

import java.util.Observable;
import java.util.Observer;

import partie2.model.EnumFigure;
import partie2.model.Figure;
import partie2.model.FigureFactory;

public class PetitsCarresObserver implements Observer {

    PetitsCarres pc;

    public PetitsCarresObserver(PetitsCarres p) {
        super();
        this.pc = p;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.pc.event = true;
        this.pc.repaint();
    }
}
