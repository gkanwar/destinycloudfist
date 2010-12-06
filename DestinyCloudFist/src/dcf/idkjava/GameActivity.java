package dcf.idkjava;

import dcf.idkjava.main.Game;
import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity
{
	Game m_game;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		
		loop();
	}
	
	private void loop()
	{
		while(!m_game.isOver())
		{
			m_game.mainLoop();
		}
	}
}
