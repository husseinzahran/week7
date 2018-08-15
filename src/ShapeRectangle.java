

import java.awt.*;

public class ShapeRectangle extends Shape
{
    
	public ShapeRectangle(int x, int y, int height, int width, Color color)
	{
	    super(x, y, height, width, color);
	}

	public void draw(Graphics g)
	{
	    g.setColor(getColor());
	    
	    g.fillRect(getXpos() - getWidth()/2, getYpos() - getHeight()/2, getWidth(), getHeight());
	}
}