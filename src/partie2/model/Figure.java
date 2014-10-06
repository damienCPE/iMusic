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
	public Graphics creationFigure() {
		
		this.r = (int) (Math.random() * 250);
        this.gr = (int) (Math.random() * 250);
        this.b = (int) (Math.random() * 250);

        this.graphic.setColor(new Color(r,gr,b));

        this.ht = (int) ((Math.random() * 120) + 10);
        this.width = (int) ((Math.random() * 120) + 10);

        this.x = (int) ((Math.random() * 40) + 10);
        this.y = (int) ((Math.random() * 40) + 10);
		
		return this.graphic;
	}
	
}
