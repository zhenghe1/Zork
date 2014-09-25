package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.logging.Logger;
import java.util.logging.Level;
import repository.images.Characters;
import java.io.ObjectStreamClass;
//Additional imports here

//JPanel is a subclass of JComponent and 
//has more capabilities than JComponent,
//so we can use it instead
public class ViewerPanel extends JPanel
{  
	private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(ViewerPanel.class).getSerialVersionUID();
  }
	//-- Class variables --------------------------------------------------------
  /**
   * Gets Logger object
   */
	public static Logger log;
  static
  {
    log = Logger.getLogger("ViewerPanel");
  }
  
	//-- Instance constants -----------------------------------------------------

  //panel width 
  public final int WIDTH;  
  
  //panel height
  public final int HEIGHT; 
  
  //generic character image
  private Characters character; 
  // Other declarations here

  //-- Methods ----------------------------------------------------------------
  
  //-- Constructors -----------------------------------------------------------
  /**
   *  Creates a panel given width and height 
   */
  public ViewerPanel(int width, int height)
  {    
  	setUpLogging();
  	log.info("Viewer Panel");
  	
    WIDTH = width;
    HEIGHT = height;
    
    // Coordinates place character in middle of the screen
    // Modify as necessary for your own characters
    // WATCH OUT FOR INTEGER DIVISION when it gets more complicated!!
    character = new Characters(WIDTH/2, HEIGHT/2);
    // create other objects here
  }

  //-- Class Helper Methods ---------------------------------------------------

  private static void setUpLogging()
  {
    log.setLevel(Level.ALL);     
    log.setLevel(Level.OFF);
  }  

  //-- Instance Methods -------------------------------------------------------
  // This method is never invoked directly
  // Responsible for "painting" panel
  public void paintComponent(Graphics g)
  {
    log.info("BEGIN paintComponent");
  	// Invoke superclass methods first:  superclass is a JPanel
    // Make background opaque instead of transparent
    super.setOpaque(true); 
    // You can change background color to anything you like
    super.setBackground(Color.WHITE); 
    // Paints background:  
    //   will cover up any artifacts remaining from previous paint
    super.paintComponent(g); 

    // Cast to Graphics2D
    // Do you remember why?
    Graphics2D g2 = (Graphics2D) g; 
    
    character.draw(g2);  
    // Invoke draw() method for other object here
    // Watch out for order of operations 
  } 
}