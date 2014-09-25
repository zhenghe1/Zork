package repository.strategies;
import game.Constants;
import java.io.Serializable;
import java.io.ObjectStreamClass;

public class OK implements CombatStrategy, Constants, Serializable
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(OK.class).getSerialVersionUID();
  }
	public int rangeMax, rangeOffset;
	public double attackFactor, defenseFactor;
	public String strategyName;
	
	public OK()
	{
		rangeMax = 43;
		rangeOffset = 43;
		attackFactor = 1;
		defenseFactor = 1;
		strategyName = "OK";
	}
	
	public OK(int rangeMax, int rangeOffset, double attackFactor, double defenseFactor, String strategyName)
	{
		this.rangeMax = rangeMax;
		this.rangeOffset = rangeOffset;
		this.attackFactor = attackFactor;
		this.defenseFactor = defenseFactor;
		this.strategyName = strategyName;
	}
	
	public double getMaxHealth()
	{
		return rangeOffset + RANDOM.nextInt(rangeMax);
	}
	
	public double getMaxStrength()
	{
		return rangeOffset % (MAX_HEALTH_POSSIBLE / MAX_STRENGTH_POSSIBLE) + RANDOM.nextInt(rangeMax % (MAX_HEALTH_POSSIBLE / MAX_STRENGTH_POSSIBLE));
	}
	
public String getStrategyName()
{
	return strategyName;
}
	
	public String toString()
	{
		return " "+ strategyName +"\nAttack Factor: "+ attackFactor +"\nDefense Factor: "+ defenseFactor;
	}
	
	public double attack(double health, double strength)
	{
		return  ((strength / HEALTH_SCALE) * health) * attackFactor;
	}
	
	public double healthAttackReceived(double health, double force)
	{
		return health - (force / defenseFactor);
	}
	
	public double strengthAttackReceived(double strength, double force)
	{
		return strength - ((force / defenseFactor) / STRENGTH_SCALE);
	}
	
	public double restoreHealth(double health, double maxHealth)
	{
		return Math.min(maxHealth, (health + (maxHealth / STRENGTH_SCALE)));
	}
	
	public double restoreStrength(double strength, double maxStrength)
	{
		return Math.min(maxStrength, (strength + (maxStrength / STRENGTH_SCALE)));
	}
	
	public double reduceStrength(double strength, double maxStrength)
	{
		return Math.max(0, (strength - (maxStrength / STRENGTH_SCALE)));
	}
	
	public int getRangeOffset()
	{
		return rangeOffset;
	}
}
