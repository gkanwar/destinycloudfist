package dcf.idkjava;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class NewGameActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newgame);
	}
	
	public void onFileSelected()
	{
		View[] playerOptionViews;
		//Get filename
		//Read file and find max players
		
		//Loop through players and create a new view for each one
		playerOptionViews = new View[5/*numPlayers*/];
		for(int i = 0; i < 5/*numPlayers*/; i++)
		{
			playerOptionViews[i] = createPlayerOptionsView(i);
		}
	}
	
	public View createPlayerOptionsView(int viewNum)
	{
		View temp = getLayoutInflater().inflate(R.layout.playeroption, null);
		addContentView(temp, null);
		
		temp.setId(viewNum);
		return temp;
	}
}
