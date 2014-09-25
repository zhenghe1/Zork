package repository.strategies;
import java.io.ObjectStreamClass;

public class Wimpy extends OK implements CombatStrategy
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Wimpy.class).getSerialVersionUID();
  }
	public Wimpy()
	{
		super(RANGE_MAX, RANGE_OFFSET, ATTACK_FACTOR, DEFENSE_FACTOR, STRATEGY_NAME);
	}
	
	public static final int RANGE_MAX = 33;
	public static final int RANGE_OFFSET = 1;
	public static final double ATTACK_FACTOR = 0.5;
	public static final double DEFENSE_FACTOR = 1.5;
	public static final String STRATEGY_NAME = "Wimpy";
}
