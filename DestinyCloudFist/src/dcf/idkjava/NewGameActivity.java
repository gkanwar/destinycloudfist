package dcf.idkjava;

import java.util.ArrayList;

import dcf.idkjava.main.Game;
import dcf.idkjava.main.Player;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NewGameActivity extends Activity
{
	//The number of player for the map
	private int m_numPlayers = 5;
	//Array of player name views
	private ArrayList<EditText> m_names = new ArrayList<EditText>(0);
	//Array of human values
	private ArrayList<CheckBox> m_human = new ArrayList<CheckBox>(0);
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);
		onFileSelected();
	}
	
	public void onFileSelected()
	{
		//TODO: Get filename
		//TODO: Read file and find numPlayers
		
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
	
	public void createGame(View v)
	{
		Game createdGame;
		ArrayList<Player> players = new ArrayList<Player>(0);
		for(int i = 0; i < m_numPlayers; i++)
		{
			players.add(new Player(m_names.get(i).getText().toString(), m_human.get(i).isChecked()));
		}
	}
}
