package dcf.idkjava.main;

import java.util.ArrayList;
import java.util.Iterator;

public class Continent
{
	//List of all territories in the Continent
	private ArrayList<Territory> m_territories;
	//Value of the continent
	private int m_value;
	
	//Constructors
	public Continent()
	{
		m_territories = new ArrayList<Territory>();
		m_value = 0;
	}
	public Continent(ArrayList<Territory> territories, int value)
	{
		m_territories = new ArrayList<Territory>(territories);
		m_value = value;
	}
	public Continent(ArrayList<Territory> territories)
	{
		m_territories = new ArrayList<Territory>(territories);
	}
	public Continent(int value)
	{
		m_value = value;
	}
	
	//Checks to see if the whole continent is owned by a player
	public boolean isOwned(Player player)
	{
		Iterator<Territory> iterator = m_territories.iterator();
		
		while(iterator.hasNext())
		{
			if (((Territory)iterator).getOwner() != player)
			{
				return false;
			}
		}
		return true;
	}
	
	//Get a list of territories (not currently used)
	public ArrayList<Territory> getTerritories()
	{
		return m_territories;
	}
	//Get the continent value
	public int getValue()
	{
		return m_value;
	}
}
