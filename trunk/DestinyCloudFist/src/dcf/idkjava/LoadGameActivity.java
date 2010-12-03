package dcf.idkjava;

import android.app.Activity;
import android.os.Bundle;

public class LoadGameActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loadgame);
	}
	
	public void onFileSelected()
	{
		//Get filename
		//Read file and find max players
		//Loop through players and create a new view for each one
		for(int i = 0; i < 5/*numPlayers*/; i++)
		{
			createPlayerOptionsView(i);
		}
	}
	
	public void createPlayerOptionsView(int viewNum)
	{
		addContentView(getLayoutInflater().inflate(R.layout.playeroption, null), null);
	}
}
