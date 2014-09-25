package repository.strategies;
import java.util.ArrayList;
import game.Constants;
import java.io.Serializable;
import java.io.ObjectStreamClass;

public class strategiesList implements Constants, Serializable
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(strategiesList.class).getSerialVersionUID();
  }
	private static ArrayList<CombatStrategy> strategies;
	static
	{
		strategies = new ArrayList<CombatStrategy>();
		strategies.add(new Wimpy());
		strategies.add(new OK());
		strategies.add(new Brawny());
	}
	
	public static CombatStrategy getStrategy()
	{
		return strategies.get(RANDOM.nextInt(strategies.size()));
	}
}
