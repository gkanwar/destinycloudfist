package dcf.idkjava;

import dcf.idkjava.main.Game;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GameActivity extends Activity
{
	//The Game object being used
	private Game m_game;
	//A Menu object (possibly not needed)
	private Menu m_menu;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		getMenuInflater().inflate(R.menu.optionsmenu, m_menu);
		
		Bundle objectBundle = getIntent().getExtras();
		try
		{
			m_game = (Game) objectBundle.get("Game");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		loop();
	}
	
	//Main activity loop
	private void loop()
	{
		while(!m_game.isOver())
		{
			m_game.mainLoop();
		}
		
		startActivity(new Intent(this, GameOverActivity.class));
		finish();
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.saveandquit:
				saveAndQuit();
				return true;
			case R.id.quit:
				quit();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	//Menu actions
	private void saveAndQuit()
	{
		//TODO: Implement saving stuff here
		finish();
	}
	private void quit()
	{
		finish();
	}
}
