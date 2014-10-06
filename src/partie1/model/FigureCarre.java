package partie1.model;

import java.awt.Graphics;

public class FigureCarre extends Figure {

	@Override
	public Graphics creationFigure() {
		super.creationFigure();
		this.graphic.fillRect(this.x,this.y,this.ht, this.width);
		return this.graphic;
	}
	
}
