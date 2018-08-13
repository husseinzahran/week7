
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class DrawingTool extends JPanel implements  MouseListener, MouseMotionListener
{
     @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {}
    
    
    
    public Image image;                   
    
    private boolean isDrawing;          
    private Graphics2D dragGraphics;    
    public Color brushColor;            
    int brushPoints[][];                
    protected Boolean mousePressed;     
    public Palette currentTool;            
    public PaletteTools currentToolDetails;  
    public Color backgroundColor;           

    
    int imageWidth, imageHeight;            
    private int mouseX, mouseY;         
    private int prevX, prevY;           
    private int startX, startY;         

    public DrawingTool()
    {
        backgroundColor = Color.white;                  
        setBackground(backgroundColor);
        setPreferredSize(new Dimension(1024, 768));     
        addMouseListener(this);                         
        addMouseMotionListener(this);                   
        mousePressed = false;                         
        brushColor = Color.black;                       
        currentTool = PaletteCreator.createTool(PaletteCreator.PENCILL_TOOL);             
        currentToolDetails = new PaletteTools(brushColor, 5, PaletteCreator.PENCILL_TOOL);    
    }


   
    private void drawGraphics(Graphics2D graphics2D, Palette currentTool, int pointX1, int pointY1, int pointX2, int pointY2)
    {
        if (currentTool.toolType == PaletteCreator.LINE_TOOL)                  
        {                                                                   
            graphics2D.setStroke(new BasicStroke(currentToolDetails.strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            graphics2D.drawLine(pointX1, pointY1, pointX2, pointY2);        
            repaint();                                                      
            return;
        }
        
        int positionX, positionY;   
        int weight, height;         
        if (pointX1 >= pointX2)
        {  
            positionX = pointX2;
            weight = pointX1 - pointX2;
        }
        else
        {   
            positionX = pointX1;
            weight = pointX2 - pointX1;
        }
        if (pointY1 >= pointY2)
        {  
            positionY = pointY2;
            height = pointY1 - pointY2;
        }
        else
        {   // pointY1 is top edge
            positionY = pointY1;
            height = pointY2 - pointY1;
        }

        

       

       
    }

   
    private void repaintRectangle(int pointX1, int pointY1, int pointX2, int pointY2)
    {
        int x, y;  
        int w, h;  
        if (pointX2 >= pointX1)
        {   
            x = pointX1;
            w = pointX2 - pointX1;
        }
        else
        {   
            x = pointX2;
            w = pointX1 - pointX2;
        }
        if (pointY2 >= pointY1)
        {   
            y = pointY1;
            h = pointY2 - pointY1;
        }
        else
        {   
            y = pointY2;
            h = pointY1 - pointY2;
        }
        repaint(x, y, w+1, h+1);      
    }

   
    private void createOffScreenImage()
    {
        if (image == null || imageWidth != getSize().width || imageHeight != getSize().height) {
            
            image = null;  
            image = createImage(getSize().width, getSize().height);
            imageWidth = getSize().width;
            imageHeight = getSize().height;
            Graphics graphics = image.getGraphics();  
            graphics.setColor(getBackground());
            graphics.fillRect(0, 0, imageWidth, imageHeight);
            graphics.dispose();
        }
    }

    
    public void paintComponent(Graphics graphics)
    {
        createOffScreenImage();                             
        Graphics2D graphics2D = (Graphics2D)graphics;       
        graphics.drawImage(image, 0, 0, this);              
        if (isDrawing &&                                    
                currentTool.toolType != PaletteCreator.PENCILL_TOOL  ) 
        {
            graphics.setColor(brushColor);                                            
            drawGraphics(graphics2D, currentTool, startX, startY, mouseX, mouseY);    
        }

    }

    public void setOSImage (BufferedImage image)
    {
        this.image = image;                          
        repaint();
    }

    public void setImage(BufferedImage image)  
    {
        int w = image.getWidth();
        int h = image.getHeight();
        this.image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        this.image = createImage(w, h);
        imageWidth = getSize().width;
        imageHeight = getSize().height;
        repaint();
        Graphics graphics = this.image.getGraphics();  
        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, imageWidth, imageHeight);
        graphics.dispose();
    }

   
    private Color getCurrentColor()             
    {
        
            return currentToolDetails.getColor();
       
    }

  
    public void mousePressed(MouseEvent evt)
    {
        if (isDrawing)                   
            return;                     

        prevX = startX = evt.getX();    
        prevY = startY = evt.getY();

        brushColor = getCurrentColor(); 
        dragGraphics = (Graphics2D) image.getGraphics(); 
        dragGraphics.setColor(brushColor);              
        dragGraphics.setBackground(getBackground());

        isDrawing = true;                               
    }

    
    public void mouseReleased(MouseEvent evt)
    {
        if (!isDrawing)
            return;             
        isDrawing = false;      
        mouseX = evt.getX();    
        mouseY = evt.getY();

        if (currentTool.toolType != PaletteCreator.PENCILL_TOOL )
        {
            repaintRectangle(startX, startY, prevX, prevY);
            if (mouseX != startX && mouseY != startY) {
                
                drawGraphics(dragGraphics, currentTool, startX, startY, mouseX, mouseY);
                repaintRectangle(startX, startY, mouseX, mouseY);
            }
        }
        dragGraphics.dispose();
        dragGraphics = null;
    }

  
    public void mouseDragged(MouseEvent evt)
    {
        if (!isDrawing)
            return;  

        mouseX = evt.getX();   
        mouseY = evt.getY();   

        
        drawGraphics(dragGraphics, PaletteCreator.createTool(PaletteCreator.LINE_TOOL), prevX, prevY, mouseX, mouseY); 
        repaintRectangle(prevX, prevY, mouseX, mouseY);

        prevX = mouseX; 
        prevY = mouseY;
    }

   

}
