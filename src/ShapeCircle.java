


import java.awt.*;

public class ShapeCircle extends Shape
{

    private int radius;
    
    public ShapeCircle(int x, int y, int radius, Color color)
    {
        super(x, y, 0, 0, color);
        
        setRadius(radius);
    }
    
    public int getRadius()
    {
        return radius;
    }
    
    public void setRadius(int radius)
    {
        if (radius > 0)
            this.radius = radius;
    }
    
  
    public void draw(Graphics g)
    {
        g.setColor(getColor());
        
        g.fillOval(getXpos() - getRadius()/2, getYpos() - getRadius()/2, getRadius(), getRadius());
    }
}