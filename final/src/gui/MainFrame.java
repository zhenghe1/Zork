package gui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Responsibility
 *   create a frame to view and control a Counter 
 */
public class MainFrame 
{
	//-- Class variables --------------------------------------------------------
	
	// Gets Logger object for debugging
  public static Logger log;
  static
  {
    log = Logger.getLogger("MainFrame");
  }

  //-- Methods ----------------------------------------------------------------

  //-- Class Helper Methods ---------------------------------------------------
  /**
   * Turns Logger object on and off
   */
  private static void setUpLogging()
  {
    log.setLevel(Level.ALL);     
    log.setLevel(Level.OFF);
  }  
  
  /**
   * Creates and displays frame, and everything in it  
   */
  private static void createAndShowFrame() 
  {
  	// Start logging
  	setUpLogging();

  	// Create and set up frame window
    JFrame frame = new JFrame("NewZork");
    frame.setSize(1500, 250);
    // Prevent program from running after window closed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      

    // Create and set up panel
    //Local variable used to hold panels until they are added to frame
    //Don't need to keep reference to both panels in THIS program
    //If necessary, declare as many panel reference variables as needed
    JPanel panel;
    
    //Creates and delivers the panels for our GUI
    PanelCreator creator = new PanelCreator();
    log.info("Create Controller Panel");   
    panel = creator.getControlPanel();  //CONTROLLER
    log.info("Create Controller Panel Done");    

    //Add control panel to frame
    //The BorderLayout manager is the default for frames
    frame.add(panel, BorderLayout.WEST); //Same as EAST

    log.info("Create Viewer Panel");   
    panel = creator.getViewPanel();  //VIEW
    log.info("Create Viewer Panel Done");    
    //Add viewer panel to frame
    frame.add(panel, BorderLayout.CENTER);

    log.info("Make window and panels visible");
    // Initiates displaying of frame and painting of panel
    frame.setVisible(true);      
    log.info("Make window and panels visible Done");
    log.info("End of MainFrame code");
  }

  //-- Main method ------------------------------------------------------------

  //Use this for GUI main methods:  
  public static void main(String[] args) 
  {
    //Schedule a job for the event-dispatching thread:
    //  creating and showing this application's Frame.
    //It is not necessary for this application but 
    //  using it will avoid possible problems.
    class AnotherControlFlow implements Runnable 
    {
      public void run() 
      {
        createAndShowFrame();
      }
    }
    javax.swing.SwingUtilities.invokeLater(new AnotherControlFlow());
  }
}