package repository.strategies;

public interface CombatStrategy 
{
	public abstract double getMaxHealth();
	
	public abstract double getMaxStrength();
	
	public abstract String getStrategyName();
	
	public abstract String toString();
	
	public abstract double attack(double health, double strength);
	
	public abstract double healthAttackReceived(double health, double force);
	
	public abstract double strengthAttackReceived(double strength, double force);
	
	public abstract double restoreHealth(double health, double maxHealth);
	
	public abstract double restoreStrength(double strength, double maxStrength);
	
	public abstract double reduceStrength(double strength, double maxStrength);
	
	public abstract int getRangeOffset();
}
