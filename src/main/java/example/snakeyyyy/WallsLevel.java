package example.snakeyyyy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class WallsLevel extends MyFrame  {
    private static final long serialVersionUID = -3641221053272056036L;

    // Snake object initialised
    public static Snake.MySnake mySnake = new Snake.MySnake(100, 100);// x , y

    // Vertical walls object initialised
    public static VerticalWalls Vwalls = new VerticalWalls();

    // Horizontal walls object initialised
    public static HorizontalWalls Hwalls = new HorizontalWalls();

    // creating new food object
    public Food food = new Food();

    // creating new image for background picture
    public Image background = ImageUtil.images.get("UI-background2");

    //method to set score initialised
    public static void SetScore(){
        mySnake.score = Play.mySnake.score;
    }

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
            Vwalls.draw(g);
            Vwalls.WallTouched(mySnake);
            Hwalls.draw(g);
            Hwalls.WallTouched(mySnake);
            if (food.l)
            {
                food.draw(g);
                food.eaten(mySnake);
            } else
            {
                food = new Food();
            }
        } else
        {
            setVisible(false);  // hide screen if snake is dead
            StartGame.DrawEndMenu(); // calls End menu to be drawn
        }
        screenGraphics.drawScore2(g);   // constantly draws score on screen

    }


}
