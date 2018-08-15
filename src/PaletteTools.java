


import java.awt.*;


public class PaletteTools extends Palette
{
    protected int strokeWidth;
    protected Color color;

     public PaletteTools(Color brushColor, int stroke, int type)
    {
        super(type);
        color = brushColor;
        strokeWidth = stroke;
    }
  public Color getColor()
    {
        return color;
    }

    public void setColor(Color clr)
    {
        color = clr;
    }

    public void setStrokeWidth(int dim)
    {
        strokeWidth = dim;
    }

    public int getStrokeWidth()
    {
        return strokeWidth;
    }
}
