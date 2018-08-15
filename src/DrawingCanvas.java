

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class DrawingCanvas extends JPanel implements MouseListener {

    int pointX, pointY, pointX2, pointY2, height, width;

    private ArrayList shapeList;

    private DrawingShape drawingShape;

    public DrawingCanvas(DrawingShape drawingShape) {
        this.drawingShape = drawingShape;

        shapeList = new ArrayList();

        setBackground(Color.white);

        addMouseListener(this);
    }

    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < shapeList.size(); i++) {
            ((Shape) shapeList.get(i)).draw(g);
        }
    }

    public void mouseClicked(MouseEvent e) {
        //Color color = program.getSelectedColor();
        // String shape = program.getSelectedShape();

        // if (shape.equals("ShapeCircle")) {
        //     shapeList.add(new ShapeCircle(e.getX(), e.getY(), 50, color));
        // } else if (shape.equals("ShapeOval")) {
        //     shapeList.add(new ShapeOval(e.getX(), e.getY(), 50, 30, color));
        // } else if (shape.equals("ShapeRectangle")) {
        //      shapeList.add(new ShapeRectangle(e.getX(), e.getY(), 55, 45, color));
        // } else {
        //     System.out.println("Invalid shape: " + shape);
        //  }
        repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        this.pointX = e.getX();
        this.pointY = e.getY();
    }

    public void mouseReleased(MouseEvent e) {

        this.pointX2 = e.getX();
        this.pointY2 = e.getY();
        this.height = (this.pointY2 - this.pointY);
        this.width = (this.pointX2 - this.pointX);

        Color color = drawingShape.getSelectedColor();
        String shape = drawingShape.getSelectedShape();

        if (shape.equals("Circle")) {
            shapeList.add(new ShapeCircle(this.pointX, this.pointY, (this.width/2), color));
        } else if (shape.equals("Oval")) {
            shapeList.add(new ShapeOval(this.pointX, this.pointY, this.height, this.width, color));
        } else if (shape.equals("Rectangle")) {
            shapeList.add(new ShapeRectangle(this.pointX, this.pointY, this.height, this.width, color));
        } else {
            System.out.println("Invalid shape: " + shape);
        }

        repaint();
    }
}
