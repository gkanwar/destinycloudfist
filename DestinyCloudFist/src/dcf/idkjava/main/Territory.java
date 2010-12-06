package dcf.idkjava.main;

import java.util.ArrayList;

public class Territory
{
	//Array of adjacent territories
	ArrayList<Territory> m_adj;
	//Player who owns it
	Player m_owner;
	//Continent that it is part of
	Continent m_cont;
	
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
}