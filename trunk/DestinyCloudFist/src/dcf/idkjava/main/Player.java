package dcf.idkjava.main;

import java.util.ArrayList;

public class Player
{
	//The name of the player
	private String m_name;
	//Player income
	private int m_income;
	//Is the player human?
	private boolean m_isHuman;
	//Gets a card this turn?
	private boolean m_getsCard = false;
	//Territories owned
	private ArrayList<Territory> m_terrs;
	//Cards held
	private ArrayList<Card> m_cards;
	
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
	
	//Getters
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
	
	//Card functions
	public boolean getsCard()
	{
		return m_getsCard;
	}
	public void setCard(boolean cardState)
	{
		m_getsCard = cardState;
	}
	public void giveCard(Card givenCard)
	{
		m_cards.add(givenCard);
	}
	
	//UI functions
	public void askTurnInSet()
	{
		//Ask if the player wants to turn in a set of cards and which one they do.
	}
	public void place()
	{
		//Have the player place m_income units
	}
	public boolean askAttack()
	{
		//Ask if the player wants to make another attack
		return false;
	}
	public Combat makeAttack()
	{
		//Input the player's attack
		return null;
	}
	public void makeMoves()
	{
		//Ask the user which units they want to move to finish
	}
}
