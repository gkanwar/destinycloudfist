package dcf.idkjava.main;

public class Combat
{
	private static boolean VICTORY = true;
	private static boolean DEFEAT = false;
	
	private Player m_attacker, m_defender;
	private Territory m_attacking, m_defending;
	int m_numAttackers;
	
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
			//Stuff
		}
		
		//More stuff, do later
	}
	
	private boolean over()
	{
		return false;
		//Stuff
	}
	private boolean didAttackWin()
	{
		return false;
		//Stuff
	}
	private boolean askRetreat()
	{
		return false;
		//Stuff
	}
	private void update(boolean thingy)
	{
		//Stuff
	}
}
