package characters;

import java.io.ObjectStreamClass;

/** An Adventurer has a name, number of sacks of
 *  treasure collected, Strength and health which
*/

public class Adventurer extends Character {
	
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Adventurer.class).getSerialVersionUID();
  }
	
	/**
	 * Constructs an Adventurer with all values default
	 * in-case someone instantiates an adventurer by accident
	*/
	public Adventurer()
	{
		this(SINGLE_ADVENTURER_NAMES.takeNames(), 1 + RANDOM.nextInt(MAX_HEALTH_POSSIBLE), 1 + RANDOM.nextInt(MAX_STRENGTH_POSSIBLE));
	}
	
	/**
	 * Constructs an Adventurer with a name, strength,
	 * number of sacks and default health 100;
	 * @param name Name of the Adventurer
	 * @param health Amount of health to set and its max health
	 * @param strength Strength of Adventurer
	 */
	public Adventurer(String name, double health, double strength)
	{
		super(name, 0, health, strength);
	}
	
	// Accessor
	/**
	 * Calculates the force of a poke
	 * @return force
	 */
	public double pokeMonster()
	{
		return super.getStrategy().attack(super.getHealth(), super.getStrength());
	}
	
	// Mutator

	/**
	 * Subtracts force from the Adventurer's current health
	 * @param force Amount to subtract
	 * (Precondition: health = 0)
	 */
	public void sufferTerror(double force)
	{
		super.setHealth(super.getStrategy().healthAttackReceived(super.getHealth(), force));
		
		super.setStrength(super.getStrategy().strengthAttackReceived(super.getStrength(), force));
	}
	
	//Predicate
	
	/**
	 * Checks that the Adventurer has number of sacks to win
	 * @return true if Adventurer has sacks
	 */
	public boolean hasSacksToWin()
	{
		return super.getSacks() >= MIN_SACKS_TO_WIN;
	}
	
	/**
	 * Returns state of the Adventurer
	 * @return string Name, Health, Strength, Sacks
	 */
	public String toString(){
		return super.toString();
	}
	
}
