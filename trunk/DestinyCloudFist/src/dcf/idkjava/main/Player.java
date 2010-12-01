package dcf.idkjava.main;

import java.util.ArrayList;

public class Player
{
	//The name of the player
	String m_name;
	//Is the player human?
	boolean m_isHuman;
	//Territories owned
	ArrayList<Territory> m_terrs;
	//Continents owned
	ArrayList<Continent> m_conts;
	
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
		//TODO: Make some way for checking continent making
	}
	//Remove a territory from the player's ownership
	public void removeTerritory(Territory terr)
	{
		m_terrs.remove(terr);
		//TODO: Make some way for checking continent breaking
	}
}
