package desmenes;
import java.util.EnumMap;
import utility.SingleRandom;
import java.io.ObjectStreamClass;
import java.io.Serializable;

public class Chamber implements Serializable
{
	private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Chamber.class).getSerialVersionUID();
  }
	private static final int NONE = -1;
	private boolean visited;
	private final Location location;
	private int monsterID;
	public static SingleRandom RANDOM = SingleRandom.getInstance();
	EnumMap<Direction, Wall> walls = new EnumMap<Direction, Wall> (Direction.class);
	
	public Chamber()
	{
		this.location = new Location();
		this.monsterID = NONE;
		this.visited = false;
		
		walls.put(Direction.NORTH, Wall.BLANK);
		walls.put(Direction.EAST, Wall.BLANK);
		walls.put(Direction.SOUTH, Wall.BLANK);
		walls.put(Direction.WEST, Wall.BLANK);
		
		int random = RANDOM.nextInt(4);
		
		if(random == 0)
			walls.put(Direction.NORTH, Wall.DOOR);
		else if(random == 1)
			walls.put(Direction.EAST, Wall.DOOR);
		else if(random == 2)
			walls.put(Direction.SOUTH, Wall.DOOR);
		else
			walls.put(Direction.WEST, Wall.DOOR);
	}
	
	public Chamber(Location location, EnumMap<Direction, Wall> walls, int monsterID)
	{
		this.location = new Location(location.getColumn(), location.getRow());
		this.monsterID = monsterID;
		this.visited = false;
		this.walls = walls;
	}
	
	public Location getLocation()
	{
		return new Location(location);
	}
	
	public int getMonsterID()
	{
		return monsterID;
	}
	
	public boolean hasVisited()
	{
		return visited;
	}
	
	public boolean hasMonster()
	{
		return monsterID != -1;
	}
	
	public boolean isOrigin()
	{
		return location.isOrigin();
	}
	
	public Wall getWall(Direction direction)
	{
			return walls.get(direction);
	}
	
	public boolean hasDoor(Direction direction)
	{
		return walls.get(direction).hasDoor();
	}
	
	public String toString()
	{
		String formatString = String.format("%s%n%s%n%s%n%s%n", "Chamber: ",  "Location: "+ location.toString(), "Has been visited: "+ visited, "Has monster: "+ this.hasMonster());
		return formatString;
	}
}
