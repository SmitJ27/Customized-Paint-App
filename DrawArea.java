import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class DrawArea extends JComponent {
 
  // Now, we have to create an Image where we can draw the lines..
  public Image image;

  // Now, we have to create a 2D object to draw in the Application
  public Graphics2D g2;

  // Mouse coordinates
  public int currentX, currentY, oldX, oldY;
 
  public DrawArea() {
    setDoubleBuffered(false); // to check if the component is supposed to show the paint or not..
    addMouseListener(new MouseAdapter() {
      public void mousePressed(MouseEvent e) {
        // save coordinates.. x,y when mouse is pressed
        oldX = e.getX();
        oldY = e.getY();

        currentX = e.getX();
        currentY = e.getY();

        if (g2 != null) {
        g2.fillOval(currentX, currentY, 20, 20);
        repaint();
        }
      }
    });
 
    addMouseMotionListener(new MouseMotionAdapter() 
    {
      public void mouseDragged(MouseEvent e) {
        // coord x,y when drag mouse
        currentX = e.getX(); // getX will return the horizontal X position
        currentY = e.getY(); // getY will return the vertical Y position
 
        if (g2 != null) {
          // draw line if g2 context not null     
          g2.fillOval(currentX, currentY, 20, 20);   
          
          // refresh draw area to repaint
          repaint();
          
          // store current coords x,y as olds x,y
          oldX = currentX;
          oldY = currentY;
        }
      }
      
    });
  }
 
  public void paintComponent(Graphics g) {
    if (image == null) {
      // image to draw null ==> we create
      image = createImage(getSize().width, getSize().height);
      g2 = (Graphics2D) image.getGraphics(); 

      // enables anti-analiasing (anti-analiasing:- to make the lines smooth..)
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
      // renderingHint is used to render the image quality

      // to clear draw area
      clear();
    }
 
    g.drawImage(image, 0, 0, null); 
    // to draw the image as specified according the appropriate co-ordinates
    
  }
 
  // now we create exposed methods
  public void clear() {
    g2.setPaint(Color.white);
    // draw white on entire draw area to clear
    g2.fillRect(0, 0, getSize().width, getSize().height);
    repaint();
  }

  // eraser
  public void erase() {
    g2.setColor(Color.WHITE);
  }
 
  public void red() {
    // to apply red color on g2 context
    g2.setPaint(Color.red);
  }
 
  public void black() {
    // to apply black color on g2 context
    g2.setPaint(Color.black);
  }
 
  public void magenta() {
    // to apply magenta color on g2 context
    g2.setPaint(Color.magenta);
  }
 
  public void green() {
    // to apply green color on g2 context
    g2.setPaint(Color.green);
  }
 
  public void blue() {
    // to apply blue color on g2 context
    g2.setPaint(Color.blue);
  }

  public void yellow() {
    // to apply yellow color on g2 context
    g2.setPaint(Color.yellow);
  }

  public void gray() {
    // to apply gray color on g2 context
    g2.setPaint(Color.LIGHT_GRAY);
  }
 
}