package dcf.idkjava.main;

public class Card
{
	//Constants
	public final static int SOLDIER = 0;
	public final static int HORSE = 1;
	public final static int CANNON = 2;
	
	//Static matching function
	public static boolean matches(Card first, Card second, Card third)
	{
		int firstType = first.getType(), secondType = second.getType(), thirdType = third.getType();
		
		//Case 1: All the same type
		if(firstType == secondType && secondType == thirdType)
		{
			return true;
		}
		//Case 2: All different types
		else if(firstType != secondType && secondType != thirdType && thirdType != firstType)
		{
			return true;
		}
		//Case 3: Not matching
		else
		{
			return false;
		}
	}
	
	//Type of unit and territory on card
	private int m_type;
	private Territory m_terr;
	
	//Default constructor
	public Card()
	{
		//Do nothing
	}
	//Regular constructor
	public Card(int type, Territory terr)
	{
		m_type = type;
		m_terr = terr;
	}
	
	//Getters
	public int getType()
	{
		return m_type;
	}
	public Territory getTerritory()
	{
		return m_terr;
	}
	//Setters
	public void setType(int type)
	{
		m_type = type;
	}
	public void setTerritory(Territory terr)
	{
		m_terr = terr;
	}
}
