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
	
	public Figure(){}

	@Override
	public Graphics creationFigure(Graphics g,int maxHeight, int maxWidth) {
		
		this.r = (int) (Math.random() * 250);
        this.gr = (int) (Math.random() * 250);
        this.b = (int) (Math.random() * 250);
        
        this.graphic = g;

        this.graphic.setColor(new Color(r,gr,b));

        this.ht = (int) (Math.random() * maxHeight);
        this.width = (int) (Math.random() * maxWidth);

        this.x = (int) (Math.random() * (maxHeight - this.ht));
        this.y = (int) (Math.random() * (maxWidth - this.width));
		
		return this.graphic;
	}
	
}
