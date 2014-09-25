package repository.images;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.io.ObjectStreamClass;

public class Adventurer extends Characters
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Adventurer.class).getSerialVersionUID();
  }
	public Adventurer(double xLeft, double yTop)
	{
		super(xLeft - SCALE4 * 2, yTop);
	}
	
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
    super.draw(g2);
    drawStick(g2);
  }
	
  private void drawStick(Graphics2D g2)
  {
    // Use rectangles to model
    Rectangle2D.Double stick = 
      new Rectangle2D.Double(this.getXLeft() - SCALE3, this.getYTop() - SCALE1, SCALE1 / 2, SCALE4 + SCALE4);
    g2.setStroke(new BasicStroke(1.5F));
    g2.setColor(Color.ORANGE);
    g2.fill(stick);  // Fill rectangle with set color
    g2.setColor(Color.DARK_GRAY);
    g2.draw(stick); // Outline leg with set color
  }
}
