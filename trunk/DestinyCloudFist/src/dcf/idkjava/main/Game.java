package dcf.idkjava.main;

import java.util.ArrayList;

public class Game
{
	Board m_board;
	Deck m_deck;
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
		m_deck = new Deck(m_board);
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
		setupPhase(m_currPlayer);
		combatPhase(m_currPlayer);
		cleanupPhase(m_currPlayer);
		m_currPlayerIndex = (m_currPlayerIndex+1) % m_players.size();
	}
	
	//Phases in a turn
	public void setupPhase(Player currPlayer)
	{
		//Ask if the player wants to turn in a set of cards
		currPlayer.askTurnInSet();
		//Let the player place units
		currPlayer.place();
	}
	public void combatPhase(Player currPlayer)
	{
		ArrayList<Combat> attacks = new ArrayList<Combat>(0);
		//Have the player declare all attacks and build an ArrayList of Combat objects for all of these
		while(true)
		{
			if(!currPlayer.askAttack())
			{
				break;
			}
			
			attacks.add(currPlayer.makeAttack());
		}
		//Loop through and resolve all attacks
		for(int i = 0; i < attacks.size(); i++)
		{
			attacks.get(i).resolve();
		}
	}
	public void cleanupPhase(Player currPlayer)
	{
		//Give a card if a territory was captured
		if(currPlayer.getsCard())
		{
			//May have to create several classes pertaining to cards of which this is probably going to be a method
			currPlayer.giveCard(m_deck.drawCard());
		}
		
		//Ask for final moves
		currPlayer.makeMoves();
	}
}
