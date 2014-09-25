package characters;

import java.io.ObjectStreamClass;

/** A Monster has a name, number of sacks of
*  treasure collected, Strength and health which
*/

public class Monster extends Character{

private final static long serialVersionUID;   
static
{
  serialVersionUID = ObjectStreamClass.lookup(Monster.class).getSerialVersionUID();
}
private int MAX_DELAY;
private int delay;

	/**
	 * Constructs an Monster with a name and default health 100;
	 */
	public Monster()
	{
		this(SINGLE_MONSTER_NAMES.takeNames(), 1+ RANDOM.nextInt(MAX_SACKS_TO_START ), 1 + RANDOM.nextInt(MAX_HEALTH_POSSIBLE), 1 + RANDOM.nextInt(MAX_STRENGTH_POSSIBLE));
		MAX_DELAY = RANDOM.nextInt(4);
		delay = MAX_DELAY;
	}
	
	/**
	 * Constructs an Monster with a name, strength,
	 * number of sacks and default health 100;
	 * @param name Name of the Monster
	 * @param health Amount of health to set and its max health
	 * @param strength Strength of Monster
	 * @param sacks Number of sacks Monster already has
	 */
	public Monster(String name, int sacks, double health,  double strength)
	{
		super(name, sacks, health, strength);
	}
	
	// Accessors
	/**
	 * Calculates the force of a terrify
	 * @return force
	 */
	public double terrifyAdventurer(){
		return super.getStrategy().attack(super.getHealth(), super.getStrength());
	}
	
	// Mutators
	/**
	 * Subtracts force from the Monster's current health
	 * @param force Amount to subtract
	 */
	public void sufferPoke(double force){
		super.setHealth(super.getStrategy().healthAttackReceived(super.getHealth(), force));
		
		super.setStrength(super.getStrategy().strengthAttackReceived(super.getStrength(), force));
	}
	
	/**
	 * Returns state of the Monster
	 * @return string Name, Health, Strength, Sacks
	 */
	public String toString(){
		return super.toString();
	}
	
	public int getDelay()
	{
		return delay;
	}
	
	public void resetDelay()
	{
		delay = MAX_DELAY;
	}
}
