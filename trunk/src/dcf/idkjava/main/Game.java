package dcf.idkjava.main;

import java.util.ArrayList;

public class Game
{
	Board m_board;
	ArrayList<Player> m_players;
	
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
	
	public void mainLoop()
	{
		//TODO: Create main loop
	}
}
