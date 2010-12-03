package dcf.idkjava;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainMenuActivity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
	}
	
	//Called when the New Game button is clicked
	public void newGame()
	{
		startActivity(new Intent(this, NewGameActivity.class));
	}
	
	//Called when the Load Game button is clicked
	public void loadGame()
	{
		startActivity(new Intent(this, LoadGameActivity.class));
	}
}