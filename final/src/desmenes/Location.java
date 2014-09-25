package desmenes;
import java.io.ObjectStreamClass;
import java.io.Serializable;

public class Location implements Serializable
{
	private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Location.class).getSerialVersionUID();
  }
	private int column, row;
	
	public Location()
	{
		this(0, 0);
	}
	
	public Location(int column, int row)
	{
		this.column = column;
		this.row = row;
	}
	
	public Location(Location location)
	{
		this.column = location.getColumn();
		this.row = location.getRow();
	}
	
	public Location(Location location, Direction travelDirection)
	{
		this.column = location.getColumn() + travelDirection.getHorizontalOffset();
		this.row = location.getRow() + travelDirection.getVerticalOffset();
	}
	
	public int getColumn()
	{
		return column;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public boolean isOrigin()
	{
		return column == 0 && row == 0;
	}
	
	public boolean equals(Object obj)
	{
		boolean isEqual = false;
		
		if(obj != null && this.getClass() == obj.getClass())
		{
			Location newObj = (Location)(obj);
			isEqual = (newObj.getColumn() == column && newObj.getRow() == row);
		}
		
		return isEqual;
	}
	
	public int hashCode()
	{
		int columnHashCode = new Integer(column).hashCode();
		int rowHashCode = new Integer(row).hashCode();
		
		final int HASH_MULTIPLIER = 3;
		return HASH_MULTIPLIER * columnHashCode + rowHashCode;
	}
	
	public String toString()
	{
		return "Location of column "+ column +" and row "+ row;
	}
}
