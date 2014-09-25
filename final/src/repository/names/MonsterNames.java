package repository.names;
import java.io.ObjectStreamClass;

public class MonsterNames extends Names
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(MonsterNames.class).getSerialVersionUID();
  }
  private static  String[] MONSTER_NAMES = {"Rory", "Alex", "Hook", "Jasper", "Hunt"};
  private static MonsterNames  instance;
  static
  {
    instance = new MonsterNames();
  }
  
  private MonsterNames()
  {
  	super(MONSTER_NAMES);
  }
  
  public String toString()
  {
  	return "Monster names are:\n"+ super.toString();
  }
  
  public static MonsterNames getInstance()
  {
    return instance;
  }
}
