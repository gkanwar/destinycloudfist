package dcf.idkjava.main;

import java.util.ArrayList;
import java.util.Iterator;

public class Continent
{
	//TODO: implement
	/*
	 * My thoughts on this are to make an array of all the continents
	 * for every player and have each Continent object have a boolean
	 * array that indicates whether or not the player owns that territory
	 * of it. Add a function called isComplete, which checks for all trues
	 * and use that to check making or breaking of a continent whenever
	 * a territory is exchanged.
	 * RYAN NOTES
	 * I decided to make the continent have an ArrayList of the Territories
	 * in it and then simply iterate through and check to see if the player 
	 * requested owned the territory or not.  More time usage, but less memory
	 * usage, and simpler. I don't think this application needs as much 
	 * optimization as thelements or firetaps does.
	 */
	private ArrayList<Territory> m_territories; //list of all territories in the Continent
	private int m_value; //value of country
	
	public Continent()
	{
		m_territories = new ArrayList<Territory>();
		m_value = 0;
	}
	
	public Continent( ArrayList<Territory> territories, int value )
	{
		m_territories = new ArrayList<Territory>(territories);
		m_value = value;
	}
	public Continent( ArrayList<Territory> territories)
	{
		m_territories = new ArrayList<Territory>(territories);
	}
	public Continent( int value )
	{
		m_value = value;
	}
	
	
	//checks to see if the whole continent is owned by a player
	public boolean isOwned( Player player)
	{
		Iterator<Territory> iterator = m_territories.iterator();
		
		while(iterator.hasNext())
		{
			if ( ( (Territory) iterator ).getOwner() != player )
			{
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Territory> getTerritories()
	{
		return m_territories;
	}
	public int getValue()
	{
		return m_value;
	}

}
