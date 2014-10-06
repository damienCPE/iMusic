package partie2.model;

import java.awt.Graphics;

public class FigureOval extends Figure{
	@Override
	public Graphics creationFigure(int maxHeight, int maxWidth, int height, int width) {
		super.creationFigure(maxHeight, maxWidth, height, width);
		this.graphic.fillOval(this.x,this.y,this.ht, this.width);
		return this.graphic;
	}
}
