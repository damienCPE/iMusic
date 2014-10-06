package partie1.model;

import java.awt.Graphics;

public class FigureOval extends Figure{
	@Override
	public Graphics creationFigure() {
		super.creationFigure();
		this.graphic.fillOval(this.x,this.y,this.ht, this.width);
		return this.graphic;
	}
}
