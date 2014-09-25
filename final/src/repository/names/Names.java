package repository.names;
import java.util.ArrayList;
import java.io.Serializable;
import java.io.ObjectStreamClass;
import utility.*;

public class Names implements Serializable
{
  private final static long serialVersionUID;   
  static
  {
    serialVersionUID = ObjectStreamClass.lookup(Names.class).getSerialVersionUID();
  }
	public static SingleRandom RANDOM = SingleRandom.getInstance();
	private static int MAX_NAMES_TO_START;
	private static String[] NAMES;
	private ArrayList<String> names = new ArrayList<String>();
  
	public Names(String[] incomingNames)
  {
  	NAMES = incomingNames;
  	MAX_NAMES_TO_START = incomingNames.length;
  	for(String element: incomingNames)
  		names.add(element);
  }
  
  public int getMaxNamesToStart()
  {
  	return MAX_NAMES_TO_START;
  }
  
  public int getCurrentNumberOfNames()
  {
  	return names.size();
  }
  
  public String getName(int index)
  {
  	return names.get(index);
  }
  
  public int findName(String name)
  {
  	return names.indexOf(name);
  }
  
  public boolean hasName(String name)
  {
  	return findName(name) > -1;
  }
  
  public boolean hasNames()
  {
  	return !names.isEmpty();
  }
  
  public String takeNames()
  {
  	if(names.isEmpty())
  		this.resetNames();
  	int randomNum = RANDOM.nextInt(names.size());
  	String name = names.get(randomNum);
  	names.remove(randomNum);
  	return name;
  }
  
  public void addName(String name)
  {
  	names.add(name);
  }
  
  public void replaceName(int index, String name)
  {
  	names.set(index, name);
  }
  
  public void replaceName(String oldName, String newName)
  {
  	names.set(names.indexOf(oldName), newName);
  }
  
  public void eraseNames()
  {
  	names.clear();
  }
  
  public void resetNames()
  {
  	this.eraseNames();
  	for(String element: NAMES)
  		names.add(element);
  }
  
  public String toString()
  {
  	String string = "";
  	for(String element: names)
  		string += element + " ";
  	return string;
  }
}
