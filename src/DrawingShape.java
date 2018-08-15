

import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawingShape extends JFrame {

    private JPanel controlsPanel;
    private JLabel currentColorLabel;
    private JButton chooseColor;
    private DrawingCanvas drawCanvas;

    private JComboBox shape;
    private String[] shapeValues = {"Circle", "Oval", "Rectangle"};



    public DrawingShape() {
        super("Draw Shapes");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocation(100, 100);

        Container c = getContentPane();

        this.controlsPanel = new JPanel();
        this.drawCanvas = new DrawingCanvas(this);

        this.shape = new JComboBox(shapeValues);

        this.currentColorLabel = new JLabel();
        this.currentColorLabel.setPreferredSize(new Dimension(50, 20));
        this.currentColorLabel.setOpaque(true);
        this.currentColorLabel.setBackground(Color.ORANGE);

        this.chooseColor = new JButton();
        this.chooseColor.setText("Choose Color");
        this.chooseColor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Color color = JColorChooser.showDialog(null, "Please choose a color", Color.ORANGE);
                currentColorLabel.setBackground(color);
            }
        });

        this.controlsPanel.add(shape);
        this.controlsPanel.add(this.chooseColor);
        this.controlsPanel.add(currentColorLabel);

        c.add(controlsPanel, BorderLayout.NORTH);
        c.add(drawCanvas, BorderLayout.CENTER);
        setVisible(true);
    }

   
    public String getSelectedShape() {
        return shapeValues[shape.getSelectedIndex()];
    }

   
    public Color getSelectedColor() {
        return currentColorLabel.getBackground();
    }

    public static void main(String[] args) {
        new DrawingShape();
    }
}
