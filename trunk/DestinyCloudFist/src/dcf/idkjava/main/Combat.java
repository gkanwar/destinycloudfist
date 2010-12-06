package dcf.idkjava.main;

public class Combat
{
	Player m_attacker, m_defender;
	Territory m_attacking, m_defending;
	int m_qAttackers;
	
	//Empty default constructor
	public Combat() {}
	//Normally used constructor
	public Combat(Territory attacking, Territory defending)
	{
		m_attacking = attacking;
		m_defending = defending;
		m_attacker = m_attacking.getOwner();
		m_defender = m_defending.getOwner();
	}
	
	//Resolve the combat
	public void resolve()
	{
		//Loop:
		//
	}
}
