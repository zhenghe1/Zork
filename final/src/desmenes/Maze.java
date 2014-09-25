package desmenes;
import java.util.logging.Logger;
import characters.Monster;
import game.Constants;
import java.util.EnumMap;
import java.util.Set;
import java.util.logging.Level;
import java.io.ObjectStreamClass;
import java.io.Serializable;

public class Maze implements Constants, Serializable
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Maze.class).getSerialVersionUID();
  }
	public static Logger log;
  static
  {    
    log = Logger.getLogger("Chamber"); 
  }
	public static int DOORS_LEFT = 4;
  
	public Maze()
	{
		setupLogging();
		createEntranceChamber();
		createRemainingChambers();
	}
	
	public static void setupLogging()
	{
		log.setLevel(Level.OFF);
		//SingleRandom.getInstance().setSeed(2);
	}
	
	public static void createEntranceChamber()
	{
		map.put(new Location(), new Chamber());
		Chamber entranceChamber = map.get(new Location());
		for(Direction d: Direction.values())
		{
			if(entranceChamber.hasDoor(d))
				toBuildList.add(new Location(new Location(), d));
		}
		
		DOORS_LEFT--;
	}
	
	public static void createRemainingChambers()
	{
		while(toBuildList.size() > 0)
		{
			Chamber newChamber = new Chamber();
			
			if(RANDOM.nextInt(MONSTER_ODDS) > 0)
			{
				monsters.add(new Monster());
				newChamber = new Chamber(toBuildList.get(0), createWalls(toBuildList.get(0)), monsters.size() - 1);
			}
			else
			{
				newChamber = new Chamber(toBuildList.get(0), createWalls(toBuildList.get(0)), NONE);
			}
			map.put(toBuildList.get(0), newChamber);
			toBuildList.remove(0);
		}
	}
	
	public static EnumMap<Direction, Wall> createWalls(Location thisLocation)
	{
		EnumMap<Direction, Wall> walls = new EnumMap<Direction, Wall> (Direction.class);
		walls.put(Direction.NORTH, Wall.BLANK);
		walls.put(Direction.EAST, Wall.BLANK);
		walls.put(Direction.SOUTH, Wall.BLANK);
		walls.put(Direction.WEST, Wall.BLANK);
		
		for(Direction d: Direction.values())
		{
			if(map.get(new Location(thisLocation, d)) != null)
				walls.put(d, map.get(new Location(thisLocation, d)).getWall(d.opposite()));
			else if(walls.get(d) ==Wall.BLANK && DOORS_LEFT > 0)
			{
				int random = RANDOM.nextInt(DOOR_CHANCE);
				if(random != 0)
				{
					walls.put(d, Wall.DOOR);
					DOORS_LEFT--;
					for(int i = 0; i <toBuildList.size();i++)
						if(toBuildList.get(i).equals(new Location(thisLocation, d)))
						{
							toBuildList.remove(i);
							log.info("The remove of Tobuild location"+ new Location(thisLocation, d).toString());
						}
					toBuildList.add(new Location(thisLocation, d));
					log.info("The next Tobuild location"+ new Location(thisLocation, d).toString());
				}
			}
		}
		
		return walls;
	}
	
	public Chamber getChamber(Location location)
	{
		return map.get(location);
	}
	
	public boolean hasChamber(Location location)
  {
    return map.containsKey(location);
  } 
	
	public Set<Location>	getKeySet()
	{
		return map.keySet();
	}
	
	private static Monster getMonster(int monsterID)
	{
		return monsters.get(monsterID);
	}
	
	public Monster getMonster(Chamber chamber)
	{
		return getMonster(chamber.getMonsterID());
	}
	
	public String toString()
	{
		String returnString = "";
		for(Location chamberLocations: this.getKeySet())
		{
			returnString += map.get(chamberLocations).toString() + "\n";
			if(map.get(chamberLocations).hasMonster())
				returnString += this.getMonster(map.get(chamberLocations)).toString() +"\n";
			
			for(Direction d: Direction.values())
				returnString += d +" \t\t"+ map.get(chamberLocations).getWall(d).toString() +"\n";
			
			returnString += "\n";
		}
		return returnString;
	}
}
