package partie2.model;

import java.awt.Color;
import java.awt.Graphics;

public class Figure implements IFigure{
	protected Graphics graphic;
	protected int r;
	protected int gr;
	protected int b;
	protected int ht;
	protected int width;
	protected int x;
	protected int y;

	@Override
	public Graphics creationFigure(int maxHeight, int maxWidth, int height, int width) {
		
		this.r = (int) (Math.random() * 250);
        this.gr = (int) (Math.random() * 250);
        this.b = (int) (Math.random() * 250);

        this.graphic.setColor(new Color(r,gr,b));

        this.ht = (int) (Math.random() * maxHeight);
        this.width = (int) (Math.random() * maxWidth);

        this.x = (int) (Math.random() * maxHeight - height);
        this.y = (int) (Math.random() * maxWidth - width);
		
		return this.graphic;
	}
	
}