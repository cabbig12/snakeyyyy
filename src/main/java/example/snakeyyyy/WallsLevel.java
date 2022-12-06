package example.snakeyyyy;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WallsLevel extends MyFrame  {
    private static final long serialVersionUID = -3641221053272056036L;

    public static Snake.MySnake mySnake = new Snake.MySnake(100, 100);// x , y
    public Food food = new Food();

    public Image background = ImageUtil.images.get("UI-background2");
    public static void SetScore(){
        mySnake.score = Play.mySnake.score;
    }
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
        } else
        {
            setVisible(false);
            StartGame.DrawEndMenu();
        }
        screenGraphics.drawScore2(g);
        System.out.println(mySnake.score);

    }

    public void AddWalls(){

    }
}
