package dcf.idkjava;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class NewGameActivity extends Activity
{
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
		//TODO: Read file and find max players
		
		LinearLayout m_playerOptionsLayout = (LinearLayout) findViewById(R.id.playeroptionslayout);		
		
		//Loop through players and create a new view for each one
		for(int i = 0; i < 5/*numPlayers*/; i++)
		{
			getLayoutInflater().inflate(R.layout.playeroption, m_playerOptionsLayout);
		}
	}
}
