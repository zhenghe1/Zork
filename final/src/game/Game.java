package game;

import java.io.ObjectStreamClass;
import java.io.Serializable;

import characters.Adventurer;
import characters.Monster;

public class Game implements Constants, Serializable
{
	private final static long serialVersionUID;   
	  static
	  {
	    serialVersionUID = ObjectStreamClass.lookup(Game.class).getSerialVersionUID();
	  }
		Adventurer invader;
		Monster citizen;
		
		public Game()
		{
			invader = null;
			citizen = null;
		}
		
		public void createNewAdventurer()
		{
			invader = new Adventurer();
		}
		
		public void createNewMonster()
		{
			citizen = new Monster();
		}
		
		public void defendAdventurer(double force)
		{
			invader.sufferTerror(force);
			if(invader.getHealth() == 0 || invader.getStrength() == 0)
			{
				invader.decrementSacks();
				invader.restoreStrength();
				this.winRoundMonster();
			}
		}
		
		public void defendMonster(double force)
		{
			citizen.sufferPoke(force);
			if(citizen.getHealth() == 0 || citizen.getStrength() == 0)
			{
				citizen.decrementSacks();
				citizen.restoreStrength();
				this.winRoundAdventurer();
			}
		}
		
		public void winRoundAdventurer()
		{
			invader.incrementSacks();
			invader.restoreHealth();
			invader.reduceStrength();
		}
		
		public void winRoundMonster()
		{
			citizen.incrementSacks();
			citizen.restoreHealth();
			citizen.reduceStrength();
		}
		
		public double attackAdventurer()
		{
			return invader.pokeMonster();
		}
		
		public double attackMonster()
		{
			return citizen.terrifyAdventurer();
		}
		
		public String adventurerString()
		{
			return invader.toString();
		}
		
		public String monsterString()
		{
			return citizen.toString();
		}
		
		public String toString()
		{
			return ""+ this.adventurerString() +" "+ this.monsterString();
		}
		
		public boolean hasAdventurer()
		{
			return invader != null;
		}
		
		public boolean hasMonster()
		{
			return citizen != null;
		}
		
		public boolean hasMonsterSacks()
		{
			return citizen.hasSacks();
		}
		
		public Game loadGame()
		{
			Storage storage = new Storage();
			Game game = null;
			storage.setOpenFile();
			if (storage.hasFile())
			{
				game = storage.read();
			}
			return game;
		}
		
		public void saveGame()
		{
			Storage storage = new Storage();
			storage.setSaveFile();
			if (storage.hasFile())
			{
				storage.write(this);
			}
		}
}
