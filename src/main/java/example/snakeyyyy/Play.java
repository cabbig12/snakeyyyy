package example.snakeyyyy;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * 
 * @Project Snakee
 * @Description Spilaðu leikinn
 * @Author Sigurður Sigurðardóttir
 * @version Ekki viss
 */ 

public class Play extends MyFrame
{

	private static final long serialVersionUID = -3641221053272056036L;

	// creating new snake object
	public static Snake.MySnake mySnake = new Snake.MySnake(100, 100);// x , y

	// creating new food object
	public Food food = new Food();

	// creating new image for background picture
	public Image background = ImageUtil.images.get("UI-background");

	// method to process key pressed
	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		mySnake.keyPressed(e);
	}


	//draws all play screen graphics
	@Override
	public void paint(Graphics g)
	{
		ScreenGraphics screenGraphics = new ScreenGraphics();
		super.paint(g);
		g.drawImage(background, 0, 0, null);

		// Controls food drawn if snake is alive otherwise draws end screen
		if (mySnake.l)
		{
			mySnake.draw(g);
			if (food.l)
			{
				food.draw(g);
				food.eaten(mySnake);
			} else
			{
				food = new Food();
			}
			if(mySnake.score > 500){		//check score and change level if condition is met
				setVisible(false);
				StartGame.StartWallsLevel();
			}
		} else
		{
			// hides current jframe and draws end menu frame
			setVisible(false);
			StartGame.DrawEndMenu();
		}
		screenGraphics.drawScore(g); // draws score on frame
	}

}
