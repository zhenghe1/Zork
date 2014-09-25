package characters;
import game.Constants;
import repository.strategies.*;
import java.io.Serializable;
import java.io.ObjectStreamClass;

public class Character implements Constants, Serializable
{
	private String name;
	private int sacks;
	private double strength, health;
	public final double MAX_HEALTH, MAX_STRENGTH;
	private CombatStrategy strategy;
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Character.class).getSerialVersionUID();
  }
	
	
	public Character(String name, int sacks, double health, double strength)
	{
		strategy = strategiesList.getStrategy();
		
		this.name = name;
		MAX_STRENGTH = strategy.getMaxStrength();
		this.strength = Math.max(strength, strategy.getRangeOffset() / STRENGTH_SCALE);
		this.strength = Math.min(MAX_STRENGTH, this.strength);
		MAX_HEALTH = strategy.getMaxHealth();
		this.health = Math.max(health, strategy.getRangeOffset());
		this.health = Math.min(MAX_HEALTH, this.health);
		this.sacks = Math.max(0, sacks);
		this.sacks = Math.min(this.sacks, MAX_SACKS);
	}
	
	// Accessors
	/**
	 * Gets the name of the Adventurer
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Gets the number of sacks the Adventurer has collected
	 * @return sacks
	 */
	public int getSacks()
	{
		return sacks;
	}
	
	/**
	 * Gets the current health of the Adventurer
	 * @return health
	 */
	public double getHealth()
	{
		return health;
	}
	
	/**
	 * Gets the strength of the Adventurer
	 * @return strength
	 */
	public double getStrength()
	{
		return strength;
	}
	
//Mutators
	/**
	 * Sets sacks to a new sacks
	 * @param sacks Desired value
	 */
	public void setSacks(int sacks)
	{
		this.sacks = Math.max(sacks, 0);
		this.sacks = Math.min(this.sacks, MAX_SACKS);
	}
	
	/**
	 * Increments the number of sacks collected by 1
	 */
	public void incrementSacks()
	{
		sacks++;
	}
	
	/**
	 * Decrements the number of sacks collected by 1
	 *  (Precondition: sacks > 0)
	 */
	public void decrementSacks()
	{
		sacks--;
	}
	
	/**
	 * Sets a new name to the Adventurer
	 * @param name Desired Name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Sets a new strength to the Adventurer
	 * @param strength Desired strength
	 */
	public void setStrength(double strength)
	{
		this.strength = Math.max(strength, 0);
		this.strength = Math.min(MAX_STRENGTH, this.strength);
	}
	
	/**
	 * Resets strength back to the MAX_STRENGTH of the Adventurer
	 */
	public void resetStrength()
	{
		strength = MAX_STRENGTH;
	}
	
	/**
	 * Restores some strength back to the Adventurer
	 */
	public void restoreStrength()
	{
		strength = strategy.restoreStrength(strength, MAX_STRENGTH);
	}
	
	/**
	 * Reduce some strength from the Adventurer
	 */
	public void reduceStrength()
	{
		strength = strategy.reduceStrength(strength, MAX_STRENGTH);
	}
	
	/**
	 * Sets the current health of the Adventurer
	 * @param health Desired Health
	 */
	public void setHealth(double health)
	{
		this.health = Math.max(health, 0);
		this.health = Math.min(MAX_HEALTH, this.health);
	}
	
	/**
	 * Resets health back to the MAX_HEALTH of the Adventurer
	 */
	public void resetHealth()
	{
		health = MAX_HEALTH;
	}
	
	/**
	 * Restores some health back to the Adventurer
	 */
	public void restoreHealth()
	{
		health = strategy.restoreHealth(health, MAX_HEALTH);
	}
	
//Predicates
	/**
	 * Checks that the Adventurer has health
	 * @return true if health is greater then 0
	 */
	public boolean hasHealth()
	{
		return health > 0.0;
	}
	
	/**
	 * Checks that the Adventurer has Strength
	 * @return true if strength is greater then 0
	 */
	public boolean hasStrength(){
		return strength > 0.0;
	}
	
	/**
	 * Checks that the Adventurer has sacks
	 * @return true if sacks is greater then 0
	 */
	public boolean hasSacks()
	{
		return sacks > 0;
	}
	
	public String toString()
	{
		String string = String.format("%s%5s%n%10s%5d%n%10s%5.1f%n%10s%5.1f%n%10s%5s%n", "Name:", name, "Sacks:", sacks, "Health:", health, "Strength:", strength, "Strategy:", strategy.toString());
		return string;
	}
	
	public CombatStrategy getStrategy()
	{
		return strategy;
	}
	
	public void setStrategy()
	{
		strategy = strategiesList.getStrategy();
	}
	
	public void setStrategy(CombatStrategy strategy)
	{
		this.strategy = strategy;
	}
}
