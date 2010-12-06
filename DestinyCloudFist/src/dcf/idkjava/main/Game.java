package dcf.idkjava.main;

import java.util.ArrayList;

public class Game
{
	Board m_board;
	ArrayList<Player> m_players;
	Player m_currPlayer;
	int m_currPlayerIndex = 0;
	boolean m_isOver = false;
	
	public Game()
	{
		//Do nothing
	}
	public Game(Board board, ArrayList<Player> players)
	{
		//Create a new game with the given board and array of players
		m_board = board;
		m_players = players;
	}
	public Game(String filename)
	{
		//Load the game data from the given filename
	}
	
	public void end()
	{
		m_isOver = true;
	}
	public boolean isOver()
	{
		return m_isOver;
	}
	
	public void mainLoop()
	{
		m_currPlayer = m_players.get(m_currPlayerIndex);
		m_currPlayer.setupPhase();
		m_currPlayer.combatPhase();
		m_currPlayer.cleanupPhase();
		m_currPlayerIndex = (m_currPlayerIndex+1) % m_players.size();
	}
}
