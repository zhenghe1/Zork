package utility;
import java.util.Random;
import java.io.Serializable;
import java.io.ObjectStreamClass;
// Author: Jonathan Farrell

/**
 * Single Random so we don't get the same psuedo-random numbers
 */
public class SingleRandom implements Serializable //Singleton Pattern from Horstmann OOD & Patterns
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(SingleRandom.class).getSerialVersionUID();
  }
  // Static Variables
  private static SingleRandom  instance;  //This is the single instance accessed by members of other classes via the getInstance() method.
  static                                  //This instantiates it once.
  {
    instance = new SingleRandom();
  }
  

  // Instance Variables
  private Random generator;  //This field remains hidden

  
  // Default and other Constructors
  /**
   * Responsibility: Creates a private SingleRandom object 
   */
  private SingleRandom()  //Since it's private, members of other classes cannot declare and instantiate it
  {
    generator = new Random();
  }
    

  // Instance methods 
  public void setSeed(int seed)  //Can invoke this for testing if desired
  {
    generator.setSeed(seed);
  }

  public int nextInt(int range) //Will return integer in range 0 to range-1
  {
    return generator.nextInt(range);
  }
  

  // Static methods  
  public static SingleRandom getInstance()  //Only way to use instance of SingleRandom class
  {
    return instance;
  }
}
