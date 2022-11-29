package example.snakeyyyy;

import java.awt.*;


public class ScreenGraphics extends Play {

    public Image background = ImageUtil.images.get("UI-background");
    public Image fail = ImageUtil.images.get("game-scene-01");

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.drawImage(background, 0, 0, null);

        // Ákveða stöðu leiksins.
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
            g.drawImage(fail, 0, 0, null);
        }
        drawScore(g);
    }

    public void drawScore(Graphics g)
    {
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.setColor(Color.MAGENTA);
        g.drawString("SCORE : " + mySnake.score, 20, 40);
    }
}
