
import javax.swing.*;
import java.awt.*;

public class PaintApplication extends JFrame
{
    /**************************************************************************************************************
     *****************************************************VARIABLES************************************************
     **************************************************************************************************************/
    public DrawingTool drawingPanel;

    /**************************************************************************************************************
     ***************************************************CONSTRUCTOR************************************************
     **************************************************************************************************************/
    public PaintApplication()
    {
        super("Leonardo Da Vinci");  //overriding JFrame's title


        drawingPanel = new DrawingTool();                              //create drawing panel
        
        add(new JScrollPane(drawingPanel), "Center");

        this.setSize(1024, 768);     //set size of the application
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //set default close operation
        this.setLocationRelativeTo(null);                               //set locating to the middle of the screen
        this.setVisible(true);                                          //set visible
    }

    
   
}
