package repository.images;

import java.awt.Color;
import java.awt.Graphics2D;
//Put additional imports here
//i.e., shapes, lines, points, etc.
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.BasicStroke;
import java.io.ObjectStreamClass;
import java.io.Serializable;

/**
 * This class models a generic character in the game of NewZork
 *
 */
public class Characters implements Serializable
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Characters.class).getSerialVersionUID();
  }
  //-- Class Constants --------------------------------------------------------
    
  //Are there certain feature sizes that remain constant?
  //Are there other feature sizes that can be defined relative to them?
  //Are there colors or color schemes to be defined?
    //Should these numbers be replaced by formulas?
  //Add or replace as needed
  public final static int SCALE1 = 36;  //Face size * (1/3)
  public final static int SCALE2 = 72;  //Face size * (2/3)
  public final static int SCALE3 = 108; //Face width and height
  public final static int SCALE4 = 125;
  public final static int PEN_WIDTH = 2; //Will be more visible than default

  
  //-- Instance Variables -----------------------------------------------------
  
  // You can use variables to represent EITHER 
  //   the top-left corner of the bounding boxes surrounding your character OR
  //   the coordinate of the midpoint of your character
  //   Note:  just make all calculations relative to it
  private double xLeft;
  private double yTop;
  
  
  //-- Constructors -----------------------------------------------------------
  
  /**
   * Create Character Image object with x,y reference point
   */
  public Characters(double xLeft, double yTop)  
  {
    this.xLeft = xLeft;
    this.yTop = yTop;
  }
    
  //-- Instance methods -------------------------------------------------------
  
  //-- Accessors --------------------------------------------------------------

  /**
   * Gets x coordinate of reference point
   * @return x coordinate
   */
  public double getXLeft()
  {
    return xLeft; 
  }
  
  /**
   * Gets y coordinate of reference point
   * @return y coordinate
   */
  public double getYTop()
  {
    return yTop;
  }
  //-- Drawing Methods --------------------------------------------------------
  
  //First drawn your character on graph paper
    //Then work out size and placement relationships
  
  /**
   * Draw character image instructions  
   * @param g2 Graphics 2D context
   */
  public void draw(Graphics2D g2)
  {
    //Insert drawing instructions for generic character, 
    //or invoke methods for drawing each part
      
      //Here's my instructions for a generic character
      //Replace w/instructions for drawing your generic character after running
      //Watch out for order of operations:  
      // each set of features will obscure portions of features drawn previously!
      //(e.g.,That's why legs have to be drawn first)
      
    BasicStroke penWidth = new BasicStroke(PEN_WIDTH);  //This is > default

    g2.setStroke(penWidth);
    drawLegs(g2);
    drawArms(g2);
    drawBody(g2);
    drawFace(g2);
    drawEyes(g2);
    drawMouth(g2);
  }

  //-- Instance Helper Methods ---------------------------------------------------------
 
  /**
   * Draw legs instructions  
   * @param g2 Graphics 2D context
   */  
  private void drawLegs(Graphics2D g2)
  {
      // Use rectangles to model
    Rectangle2D.Double leg1 = 
        new Rectangle2D.Double(xLeft, yTop + SCALE4, SCALE1, SCALE2);
    Rectangle2D.Double leg2 = 
        new Rectangle2D.Double(xLeft-SCALE1, yTop + SCALE4, SCALE1, SCALE2);
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.GRAY);
    g2.fill(leg1);  // Fill rectangle with set color
    g2.fill(leg2);  // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY);
    g2.draw(leg1); // Outline leg with set color
    g2.draw(leg2); // Outline leg with set color
    
    
  }
  
  /**
   * Draw arms instructions  
   * @param g2 Graphics 2D context
   */  
  private void drawArms(Graphics2D g2)
  {
    // Use rectangles to model
    Rectangle2D.Double arm1 = 
      new Rectangle2D.Double(xLeft - SCALE3, yTop + SCALE1, SCALE2, SCALE1);
    Rectangle2D.Double arm2 = 
      new Rectangle2D.Double(xLeft + SCALE1, yTop + SCALE1, SCALE2, SCALE1);
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.GRAY);
    g2.fill(arm1);  // Fill rectangle with set color
    g2.fill(arm2);  // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY);
    g2.draw(arm1); // Outline leg with set color
    g2.draw(arm2); // Outline leg with set color
    
  }
  
  /**
   * Draw body instructions  
   * @param g2 Graphics 2D context
   */  
  private void drawBody(Graphics2D g2)
  {
    // Use rectangles to model
    Rectangle2D.Double body = 
      new Rectangle2D.Double(xLeft - SCALE1, yTop, SCALE2, SCALE4);;
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.GRAY);
    g2.fill(body);  // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY);
    g2.draw(body); // Outline leg with set color
    
  }
  
  /**
   * Draw face instructions  
   * @param g2 Graphics 2D context
   */  
  private void drawFace(Graphics2D g2)
  {    
      // Use circle to model
      Ellipse2D.Double face = 
          new Ellipse2D.Double(xLeft-((SCALE3)/2), yTop-SCALE2, SCALE3, SCALE3); 
    g2.setColor(Color.WHITE);
    g2.fill(face);  //  Fill circle with set color
    g2.setColor(Color.DARK_GRAY);        
    g2.draw(face);  //  Outline circle with set color    
  }

  /**
   * Draw eyes instructions  
   * May want to leave this out for generic character
   * @param g2 Graphics 2D context
   */
  private void drawEyes(Graphics2D g2)
  {
      int eyeSpace = SCALE1/4;
    int eyeWidth = SCALE1/4 * 3;
    int eyeHeight = SCALE1/2;
    int eyeLevel = SCALE1 + (eyeHeight/5);  
    // Use ellipse to model
    Ellipse2D.Double leftEye = new Ellipse2D.Double(xLeft - eyeWidth-eyeSpace,
                                                yTop - eyeLevel, eyeWidth, eyeHeight);
    Ellipse2D.Double rightEye = new Ellipse2D.Double(xLeft + eyeSpace,
                                                yTop - eyeLevel, eyeWidth, eyeHeight);    
    g2.setColor(Color.BLACK);     
    g2.fill(leftEye);   // Fill ellipse with set color
    g2.fill(rightEye);  // Fill ellipse with set color
    g2.setColor(Color.LIGHT_GRAY);
    g2.draw(leftEye);  // Outline ellipse with set color
    g2.draw(rightEye); // Outline ellipse with set color     
  }
  
  /**
   * Draw mouth instructions  
   * May want to leave this out for generic character
   * @param g2 Graphics 2D context
   */
  private void drawMouth(Graphics2D g2)
  {
    g2.setColor(Color.BLACK);
    g2.drawLine((int)xLeft - SCALE1 / 2,(int) yTop,(int) xLeft + SCALE1 / 2,(int) yTop);
  }
}
