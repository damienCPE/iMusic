package partie1.model;

public class FigureFactory {
	public FigureFactory(){};
	
	public Figure creationFigure(EnumFigure type){
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
		return figure;
	}
}
