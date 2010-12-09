package dcf.idkjava.main;

import java.util.ArrayList;

public class Territory
{
	//Array of adjacent territories
	private ArrayList<Territory> m_adj;
	//Player who owns it
	private Player m_owner;
	//Continent that it is part of
	private Continent m_cont;
	//Number of units on territory
	int m_units = 0;
	
	public Territory()
	{
		//Do nothing
	}
	public Territory(ArrayList<Territory> adj)
	{
		m_adj = adj;
	}
	
	public void setOwner(Player owner)
	{
		m_owner = owner;
	}
	public Player getOwner()
	{
		return m_owner;
	}
	
	public void setUnits(int units)
	{
		m_units = units;
	}
	public int getUnits()
	{
		return m_units;
	}
	public Continent getContinent()
	{
		return m_cont;
	}
	public boolean isAdjacent(Territory terr)
	{
		for(int i = 0; i < m_adj.size(); i++)
		{
			if(m_adj.get(i) == terr)
			{
				return true;
			}
		}
		
		return false;
	}
}
