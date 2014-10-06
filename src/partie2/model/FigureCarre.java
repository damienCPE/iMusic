package partie2.model;

import java.awt.Graphics;

public class FigureCarre extends Figure {
	public FigureCarre(){}
	
	@Override
	public Graphics creationFigure(Graphics g,int maxHeight, int maxWidth) {
		super.creationFigure(g, maxHeight, maxWidth);
		this.graphic.fillRect(this.x,this.y,this.ht, this.width);
		return this.graphic;
	}
	
}
