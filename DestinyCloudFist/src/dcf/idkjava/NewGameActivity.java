package dcf.idkjava;

import java.util.ArrayList;

import dcf.idkjava.main.Board;
import dcf.idkjava.main.Game;
import dcf.idkjava.main.Player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NewGameActivity extends Activity
{
	//The number of player for the map
	private int m_numPlayers = 5;
	//Array of player name views and humanities
	private ArrayList<EditText> m_names = new ArrayList<EditText>(0);
	private ArrayList<CheckBox> m_human = new ArrayList<CheckBox>(0);
	//The filename to load from
	private String m_filename;
	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);
	}
	
	//Called when a file is selected
	public void onFileSelected()
	{
		//TODO: Get filename and store in global variable
		//TODO: Read file and find numPlayers
		
		//The parent LinearLayout of the created views
		LinearLayout playerOptionsLayout = (LinearLayout) findViewById(R.id.playeroptionslayout);		
		//Loop through players and create a new view for each one
		for(int i = 0; i < m_numPlayers; i++)
		{
			//Inflate the XML for the playeroption LinearLayout
			getLayoutInflater().inflate(R.layout.playeroption, playerOptionsLayout);
			//Add the corresponding views to the array for easy access
			m_names.add((EditText) ((LinearLayout) playerOptionsLayout.getChildAt(i)).getChildAt(1));
			m_human.add((CheckBox) ((LinearLayout) playerOptionsLayout.getChildAt(i)).getChildAt(2));
		}
	}
	
	//Called when the createGame button is pressed
	public void createGame(View v)
	{
		Game createdGame;
		Board createdBoard;
		ArrayList<Player> players = new ArrayList<Player>(0);
		
		//Create the players array
		for(int i = 0; i < m_numPlayers; i++)
		{
			players.add(new Player(m_names.get(i).getText().toString(), m_human.get(i).isChecked()));
		}
		
		//Set up the board from file
		createdBoard = buildBoardFromFile();
		
		//Create the game from the board and players
		createdGame = new Game(createdBoard, players);
		
		//Create the GameActivity passing the createdGame object
		Intent gameActivityIntent = new Intent(this, GameActivity.class);
			gameActivityIntent.putExtra("Game", createdGame);
		startActivity(gameActivityIntent);
		finish();
	}

	//Creates a Board from the global filename
	private Board buildBoardFromFile()
	{
		//TODO: Implement this
		return null;
	}
}
