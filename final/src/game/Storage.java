package game;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * This class provides object file I/O services for the Game class
 * @author Rose Williams
 *
 */
public class Storage
{ 
	//-- Class variables for debugging ------------------------------------------
	
  public static Logger log;
  static
  {
    log = Logger.getLogger("Storage");
  }  
  
  //-- Instance Variables -----------------------------------------------------
  /**
   * Virtual file object
   */
  private File file; //instance variable set in setOpenFile() and setSaveFile()
  
  //-- Methods ----------------------------------------------------------------  

  //-- Constructors -----------------------------------------------------------

  /**
   * Responsibility: Creates a Storage object 
   */  
  public Storage()
  {
    setUpLogging();
    file = null; //Don't instantiate yet (use via JFileChooser browse tool)
  }
 
  //-- Class (Helper) methods -------------------------------------------------
 
  /**
   * Responsibility: Turns logging on when desired 
   */
  private static void setUpLogging()
  {
  	//Note:  add log.info() statements if necessary
    log.setLevel(Level.ALL);     
    //log.setLevel(Level.OFF);
  }

  //------ Instance methods ---------------------------------------------------
  //-- Predicates -------------------------------------------------------------

  /**
   * Responsibility: Determines if file has been selected
   * @return true if present, false otherwise
   */   
  public boolean hasFile()
  {
    return file != null;
  }

  //-- Accessors --------------------------------------------------------------
      
  /**
   * Responsibility: reads in game from file
   * @return game to be loaded
   */
  public Game read() 
  {
    //FILL IN THE CODE:
    //Declare Game object and set to null 
  	Game game = null;
    //Declare an ObjectInputStream object and set it to null
  	ObjectInputStream in = null;
    //Note that it will read in entire game object at a time

    try 
    {
      //Instantiate ObjectInputStream object using new FileInputStream object
    	in = new ObjectInputStream(new FileInputStream(file));
      //  wrapped around file object (instance variable above)
    	//Note that this is an example of the decorator design pattern
      
      //Set Game object to result of readObject() operation
    	game = (Game)in.readObject();
    	
      try
      {
        //leave blank
      }
      finally //Close stream if created
      {
        //if ObjectInputStream object isn't null
      	if(in != null)
      		in.close(); //  close ObjectInputStream
      }
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    	log.info(e.getCause().toString());
      JOptionPane.showMessageDialog
                  (null, "Read failed:  not a valid Game file");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    	log.info(e.getCause().toString());
      JOptionPane.showMessageDialog(null, "Open failed:  IOException");
    }
    return game;
  }
  
  /**
   * Responsibility: Returns state of storage object
   * @return formatted String description of file
   */   
  public String toString()
  {
    return file!=null ? 
    			 "\nFile is:  " + file.toString() : "\nFile is undefined";
  }
  
  
  //-- Mutators ---------------------------------------------------------------

  /**
   * Responsibility: Allows user to select file to open
   * using JFileChooser
   */
    public void setOpenFile() //sets file instance variable
  {  
    file = null;  //In case it was set previously
    JFileChooser fileChooser = 
    	           new JFileChooser(new File(System.getProperty("user.dir")));
    //Set the mode of the browse tool:
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fileChooser.setDialogTitle("Load File"); //Dialog box title bar
    int option = fileChooser.showOpenDialog(null); //Lets user browse to file 
    if(option == JFileChooser.APPROVE_OPTION) //User chooses OK
    {
      file =  fileChooser.getSelectedFile();  //get chosen file to be loaded
      if (!hasFile()) // if user selects OK but doesn't select file
        JOptionPane.showMessageDialog(null, "Unsuccessful:  empty filename"); 
    }
  }

  /**
   * Responsibility: Allows user to select file to write to
   * using JFileChooser
   */  
  public void setSaveFile()  //sets file instance variable
  {
    //FILL IN THE CODE:
    //set file to null
  	file = null;
  	//create JFileChooser dialog box
  	JFileChooser fc = new JFileChooser(new File(System.getProperty("user.dir")));
    //set Dialog box mode and title bar 
    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    fc.setDialogTitle("Save File"); 
    //Set option when user finished browsing to file to be created &/or saved
    int option = fc.showSaveDialog(null);
    //if user chooses OK
    if(option == JFileChooser.APPROVE_OPTION) //User chooses OK
    {
      //get file to be saved entered by user
    	file =  fc.getSelectedFile();
      //if file is null
    	if (!hasFile())
    		JOptionPane.showMessageDialog(null, "Unsuccessful:  empty filename");         //print empty filename message  
    }
  }
    

  /**
   * Responsibility:  Writes game to file
   * @param game - game to be saved in file
   */  
  public void write(Game g)
  {
  //FILL IN THE CODE:
    //Declare ObjectOutputStream object and set it to null
  	ObjectOutputStream out = null;

    try
    {
      //Instantiate ObjectOutputStream object using new FileInputStream object 
    	out = new ObjectOutputStream(new FileOutputStream(file));
      //  wrapped around file object (instance variable above)
      
      //Using writeObject() operation, write game object to file
    	out.writeObject(g);
    	
      try
      {
        //leave blank
      }
      finally  //Close stream if created
      {
        //if ObjectInputStream object isn't null
      	if(out != null)
      		out.close(); //  close ObjectInputStream
      }
 
    }
    catch (IOException e)
    {
      e.printStackTrace();
    	log.info(e.getCause().toString());
      JOptionPane.showMessageDialog(null, "Save failed:  IOException");
    }
  } 

}