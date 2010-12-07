package dcf.idkjava.main;

public class Combat
{
	private static final boolean VICTORY = true;
	private static final boolean DEFEAT = false;
	
	private Player m_attacker, m_defender;
	private Territory m_attacking, m_defending;
	int m_numAttackers, m_numDefenders;
	
	//Empty default constructor
	public Combat() {}
	//Normally used constructor
	public Combat(Territory attacking, Territory defending, int numAttackers)
	{
		m_attacking = attacking;
		m_defending = defending;
		m_attacker = m_attacking.getOwner();
		m_defender = m_defending.getOwner();
		m_numAttackers = numAttackers;
		m_numDefenders = m_defending.getUnits();
	}
	
	//Resolve the combat
	public void resolve()
	{
		//Loop:
		//Ask attacker how many dice to use
		//Ask defender how many dice to use
		//Roll (internal) and kill off the amount of dudes req'd
		//Check for victory
			//Yes: call a function to modify continents and income
			//No: ask if attacker wants to retreat
				//Yes: modify unit nums in terrs
				//No: Goto Loop
		
		int attackDice, defendDice;
		while(true)
		{
			attackDice = askDiceAttacker();
			defendDice = askDiceDefender();
			roll(attackDice, defendDice);
			if(over())
			{
				update(didAttackWin());
			}
			else if(askRetreat())
			{
				update(DEFEAT);
				break;
			}
		}
	}
	
	private int askDiceAttacker()
	{
		return 0;
		//Ask the attacker how many dice he wants to use
	}
	private int askDiceDefender()
	{
		return 0;
		//Ask the defender how many dice he wants to use
	}

	private void roll(int attackDice, int defendDice)
	{
		int highestAttack = 0, secondHighestAttack = 0, highestDefend = 0, secondHighestDefend = 0;
		int totalDice = defendDice <= attackDice ? defendDice : attackDice;
		int numRolled;
		
		for(int i = 0; i < attackDice; i++)
		{
			numRolled = (int) (Math.random()*6)%6;
			if(numRolled >= highestAttack)
			{
				secondHighestAttack = highestAttack;
				highestAttack = numRolled;
			}
			else if(numRolled > secondHighestAttack)
			{
				secondHighestAttack = numRolled;
			}
		}
		for(int i = 0; i < defendDice; i++)
		{
			numRolled = (int) (Math.random()*6)%6;
			if(numRolled >= highestDefend)
			{
				secondHighestDefend = highestDefend;
				highestAttack = numRolled;
			}
			else if(numRolled > secondHighestDefend)
			{
				secondHighestDefend = numRolled;
			}
		}
		
		if(totalDice > 1)
		{
			if(highestAttack > highestDefend)
			{
				//Kill defender
				m_numDefenders--;
			}
			else
			{
				//Kill attacker
				m_numAttackers--;
			}
			if(secondHighestAttack > secondHighestDefend)
			{
				//Kill defender
				m_numDefenders--;
			}
			else
			{
				//Kill attacker
				m_numAttackers--;
			}
		}
		else
		{
			if(highestAttack > highestDefend)
			{
				//Kill defender
				m_numDefenders--;
			}
			else
			{
				//Kill attacker
				m_numAttackers--;
			}
		}
	}
	
	private boolean over()
	{
		return (m_numDefenders == 0 || m_numAttackers == 0);
	}
	private boolean didAttackWin()
	{
		return (m_numDefenders == 0);
	}
	private boolean askRetreat()
	{
		//Stuff
		return false;
	}
	private void update(boolean state)
	{
		if(state == VICTORY)
		{
			//Give attacker territory
			m_attacker.addTerritory(m_defending);
			m_defender.removeTerritory(m_defending);
			m_defending.setOwner(m_attacker);
		}
		
		//Set attacking and defending units in territories
		m_attacking.setUnits(m_numAttackers);
		m_defending.setUnits(m_numDefenders);
	}
}
