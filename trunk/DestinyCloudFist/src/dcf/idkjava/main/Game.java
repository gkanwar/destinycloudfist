package dcf.idkjava.main;

import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable
{
	//Has to do with Serializable
	private static final long serialVersionUID = 8246456202242912307L;
	//The objects used by the game (board, deck, players)
	private Board m_board;
	private Deck m_deck;
	private ArrayList<Player> m_players;
	private Player m_currPlayer;
	//Keeps track of the current player
	private int m_currPlayerIndex = 0;
	//Keeps track of whether this game has ended or not
	private boolean m_isOver = false;
	
	//Default constructor
	public Game()
	{
		//Do nothing
	}
	//New game constructor
	public Game(Board board, ArrayList<Player> players)
	{
		//Create a new game with the given board and array of players
		m_board = board;
		m_deck = new Deck(m_board);
		m_players = players;
	}
	//Load game constructor
	public Game(String filename)
	{
		//TODO: Load the game data from the given filename
	}
	
	//End the game
	public void end()
	{
		m_isOver = true;
	}
	//Check the state of the game
	public boolean isOver()
	{
		return m_isOver;
	}
	
	//One game loop - performs the current player's turn
	public void mainLoop()
	{
		m_currPlayer = m_players.get(m_currPlayerIndex);
		setupPhase(m_currPlayer);
		combatPhase(m_currPlayer);
		cleanupPhase(m_currPlayer);
		m_currPlayerIndex = (m_currPlayerIndex+1) % m_players.size();
	}
	
	//Phases - setup, combat, cleanup
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
