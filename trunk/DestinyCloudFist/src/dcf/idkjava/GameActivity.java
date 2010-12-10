package dcf.idkjava;

import dcf.idkjava.main.Game;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GameActivity extends Activity
{
	Game m_game;
	Menu m_menu;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		getMenuInflater().inflate(R.menu.optionsmenu, m_menu);
		
		loop();
	}
	
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
