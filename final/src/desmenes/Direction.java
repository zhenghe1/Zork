package desmenes;

import java.io.ObjectStreamClass;

public enum Direction
{
	NORTH(0, 1)
	{
		public Direction next()
		{
			return EAST;
		}
		
		public Direction opposite()
		{
			return SOUTH;
		}
		
		public String toString()
		{
			return "North";
		}
	},
	
	EAST(1, 0)
	{
		public Direction next()
		{
			return SOUTH;
		}
		
		public Direction opposite()
		{
			return WEST;
		}
		
		public String toString()
		{
			return "East";
		}
	},
	
	SOUTH(0, -1)
	{
		public Direction next()
		{
			return WEST;
		}
		
		public Direction opposite()
		{
			return NORTH;
		}
		
		public String toString()
		{
			return "South";
		}
	},
	
	WEST(-1, 0)
	{
		public Direction next()
		{
			return NORTH;
		}
		
		public Direction opposite()
		{
			return EAST;
		}
		
		public String toString()
		{
			return "West";
		}
	};
	
	private final int horizontalOffset, verticalOffset;
	
	private Direction(int horizontalOffset, int verticalOffset)
	{
		this.horizontalOffset = horizontalOffset;
		this.verticalOffset = verticalOffset;
	}
	
	public int getVerticalOffset()
	{
		return verticalOffset;
	}
	
	public int getHorizontalOffset()
	{
		return horizontalOffset;
	}
	private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Direction.class).getSerialVersionUID();
  }
	public abstract Direction next();
	
	public abstract Direction opposite();
	
	public abstract String toString();
}
