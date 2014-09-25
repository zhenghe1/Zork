package repository.names;
import java.io.ObjectStreamClass;

public class AdventurerNames extends Names
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(AdventurerNames.class).getSerialVersionUID();
  }
  private static  String[] ADVENTURER_NAMES = {"Jon", "Sora", "Pikachu", "Kenithal", "Dipsa"};
  private static AdventurerNames  instance;
  static
  {
    instance = new AdventurerNames();
  }
  
  private AdventurerNames()
  {
  	super(ADVENTURER_NAMES);
  }
  
  public String toString()
  {
  	return "Adventurer names are:\n"+ super.toString();
  }
  
  public static AdventurerNames getInstance()
  {
    return instance;
  }
}
