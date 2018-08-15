

import java.awt.*;


public class ShapeOval extends Shape
{
  
	public ShapeOval(int x, int y, int height, int width, Color color)
	{
	    super(x, y, height, width, color);
	}
	
  
	public void draw(Graphics g)
	{
	    g.setColor(getColor());
	    
	    g.fillOval(getXpos() - getWidth()/2, getYpos() - getHeight()/2, getWidth(), getHeight());
	}
}