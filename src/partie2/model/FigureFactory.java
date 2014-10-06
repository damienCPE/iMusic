package partie2.model;

import java.awt.Graphics;


public class FigureFactory {
	public FigureFactory(){};
	
	public void creationFigure(EnumFigure type, Graphics g, int maxHeight, int maxWidth){
		Figure figure = null;
		switch (type) {
		case CARRE:
			figure = new FigureCarre();
			break;
		case OVAL:
			figure = new FigureOval();
			break;

		default:
			break;
		}
		figure.creationFigure(g, maxHeight, maxWidth);
	}
}
