package dcf.idkjava.main;

import java.util.ArrayList;

public class Player
{
	//The name of the player
	private String m_name;
	private int m_income;
	//Is the player human?
	private boolean m_isHuman;
	//Gets a card this turn?
	private boolean m_getsCard = false;
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
		m_income++;
		m_getsCard = true;
		if(terr.getContinent().isOwned(this))
		{
			m_income += terr.getContinent().getValue();
		}
	}
	//Remove a territory from the player's ownership
	public void removeTerritory(Territory terr)
	{
		m_terrs.remove(terr);
		m_income--;
		if(terr.getContinent().isOwned(this))
		{
			m_income -= terr.getContinent().getValue();
		}
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
		askTurnInSet();
		//Let the player place m_income units
		place(m_income);
	}
	public void combatPhase()
	{
		ArrayList<Combat> attacks = new ArrayList<Combat>(0);
		//Have the player declare all attacks and build an ArrayList of Combat objects for all of these
		while(true)
		{
			if(!askAttack())
			{
				break;
			}
			
			attacks.add(makeAttack());
		}
		//Loop through and resolve all attacks
		for(int i = 0; i < attacks.size(); i++)
		{
			attacks.get(i).resolve();
		}
	}
	public void cleanupPhase()
	{
		//Give a card if a territory was captured
		if(m_getsCard)
		{
			//May have to create several classes pertaining to cards of which this is probably going to be a method
			giveCard();
		}
		
		//Ask for final moves
		makeMoves();
	}
	
	public boolean getsCard()
	{
		return m_getsCard;
	}
	public void setCard(boolean cardState)
	{
		m_getsCard = cardState;
	}
	
	private void askTurnInSet()
	{
		//Ask if the player wants to turn in a set of cards and which one they do.
	}
	private void place(int numUnits)
	{
		//Have the player place numUnits units
	}
	private boolean askAttack()
	{
		//Ask if the player wants to make another attack
		return false;
	}
	private Combat makeAttack()
	{
		//Input the player's attack
		return null;
	}
	private void giveCard()
	{
		//Do nothing for now
	}
	private void makeMoves()
	{
		//Ask the user which units they want to move to finish
	}
}
