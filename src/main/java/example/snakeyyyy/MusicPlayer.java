package example.snakeyyyy;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;


public class MusicPlayer extends Thread
{
	private String filename;
	private Player player;

	public MusicPlayer(String filename)
	{
		this.filename = filename;
	}

	public void play()
	{
		// method to play music file
		new Thread()
		{
			@Override
			public void run()
			{
				super.run();
				try
				{
					player = new Player(new BufferedInputStream(new FileInputStream(filename)));
					player.play();

				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}



	public static void getMusicPlay(String filename)
	{
		// method to get music file
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.play();
	}
}
