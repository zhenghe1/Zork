package desmenes;

import java.io.ObjectStreamClass;

public enum Wall
{
	DOOR
	{
		public boolean hasDoor()
		{
			return true;
		}
		
		public String toString()
		{
			return "door";
		}
	},
	
	BLANK
	{
		public boolean hasDoor()
		{
			return false;
		}
		
		public String toString()
		{
			return "wall";
		}
	};
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Wall.class).getSerialVersionUID();
  }
	public abstract boolean hasDoor();
}
