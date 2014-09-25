package repository.images;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.ObjectStreamClass;

public class Monster extends Characters
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Monster.class).getSerialVersionUID();
  }
	public Monster(double xLeft, double yTop)
	{
		super(xLeft + SCALE4 * 2, yTop);
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
    drawFangs(g2);
  }
	
  private void drawFangs(Graphics2D g2)
  {
    g2.setStroke(new BasicStroke(4.0F));
    g2.setColor(Color.RED);
    g2.drawLine((int)this.getXLeft() - SCALE1 / 2, (int) this.getYTop() + 2, (int) this.getXLeft() - SCALE1 / 2, (int) this.getYTop() + 2 + SCALE1 / 3);
    g2.drawLine((int)this.getXLeft() + SCALE1 / 2, (int) this.getYTop() + 2, (int) this.getXLeft() + SCALE1 / 2, (int) this.getYTop() + 2 + SCALE1 / 3);
  }
}