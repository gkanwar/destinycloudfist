package dcf.idkjava.main;

import java.util.ArrayList;

public class Player
{
	//The name of the player
	private String m_name;
	private int m_income;
	//Is the player human?
	private boolean m_isHuman;
	//Territories owned
	private ArrayList<Territory> m_terrs;
	
	//Default constructor
	public Player()
	{
		m_isHuman = false;
	}
	//Constructor given name and humanity
	public Player(String name, boolean isHuman)
	{
		m_name = name;
		m_isHuman = isHuman;
	}
	
	//Add a territory to the player's ownership
	public void addTerritory(Territory terr)
	{
		m_terrs.add(terr);
	}
	//Remove a territory from the player's ownership
	public void removeTerritory(Territory terr)
	{
		m_terrs.remove(terr);
	}
	public String getName()
	{
		return m_name;
	}
	public boolean isHuman() 
	{
		return m_isHuman;
	}
	public int getIncome()
	{
		return m_income;
	}
	
	public void setupPhase()
	{
		//Ask if the player wants to turn in a set of cards
		//Let the player place m_income units
	}
	public void combatPhase()
	{
		//Have the player declare all attacks and build an ArrayList of Combat objects for all of these
		//Loop through and resolve all attacks one at a time (this requires player input)
	}
	public void cleanupPhase()
	{
		//Give a card if a territory was captured
		//Ask for final moves
	}
}
