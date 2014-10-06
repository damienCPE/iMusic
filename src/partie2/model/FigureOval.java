package partie2.model;

import java.awt.Graphics;

public class FigureOval extends Figure{
	public FigureOval(){}
	
	@Override
	public Graphics creationFigure(Graphics g, int maxHeight, int maxWidth, int height, int width) {
		super.creationFigure(g, maxHeight, maxWidth, height, width);
		this.graphic.fillOval(this.x,this.y,this.ht, this.width);
		return this.graphic;
	}
}
