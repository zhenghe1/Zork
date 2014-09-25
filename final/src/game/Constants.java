package game;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import repository.names.*;
import characters.Monster;
import desmenes.*;
import utility.SingleRandom;

public interface Constants
{
	//Characters
	public static final int MIN_SACKS_TO_WIN = 10;
	public static AdventurerNames SINGLE_ADVENTURER_NAMES = AdventurerNames.getInstance();
	public static final int MAX_SACKS_TO_START = 10;
	public static MonsterNames SINGLE_MONSTER_NAMES = MonsterNames.getInstance();
	public static final double HEALTH_SCALE = 100.0, STRENGTH_SCALE = 10.0;
	public static final int MAX_HEALTH_POSSIBLE = (int)HEALTH_SCALE;
	public static final int MAX_STRENGTH_POSSIBLE = (int)STRENGTH_SCALE;
	public static final int MAX_SACKS = 10;
	
	//Maze
	public static SingleRandom RANDOM = SingleRandom.getInstance();
	static Map<Location, Chamber> map = new HashMap<Location, Chamber>();
	static ArrayList<Monster> monsters = new ArrayList<Monster>();
	public static final int DOOR_CHANCE = 4;
	public static ArrayList<Location> toBuildList = new ArrayList<Location>();
	public static int MONSTER_ODDS = 4;
	public static int NONE = -1;
}
