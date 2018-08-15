


import java.awt.*;

public abstract class Shape {

    private int xpos, ypos, height, width;

    private Color color;

    public Shape(int xpos, int ypos, int width, int height, Color color) {
        setXpos(xpos);
        setYpos(ypos);
        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    public void setXpos(int xpos) {
        if (xpos >= 0) {
            this.xpos = xpos;
        }
    }

    public void setYpos(int ypos) {
        if (ypos >= 0) {
            this.ypos = ypos;
        }
    }

    public void setHeight(int height) {
        if (height >= 0) {
            this.height = height;
        }
    }

    public void setWidth(int width) {
        if (width >= 0) {
            this.width = width;
        }
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Color getColor() {
        return color;
    }

    public abstract void draw(Graphics g);
}
