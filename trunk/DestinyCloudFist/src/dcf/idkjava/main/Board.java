package dcf.idkjava.main;

import java.util.ArrayList;

public class Board
{
	//An array of all the territories
	ArrayList<Territory> m_terrs;
	//An array of all the continents
	ArrayList<Continent> m_conts;
	
	public Board()
	{
		//Do nothing
	}
	public Board(String filename)
	{
		//TODO Load the Board from the file
	}
	
	public ArrayList<Territory> getTerritories()
	{
		return m_terrs;
	}
}
