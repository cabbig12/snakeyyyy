package example.snakeyyyy;

import java.awt.*;

public class ScreenGraphics {
    public StartMenu startMenu;
    public Play play;
    public WallsLevel wallsLevel;

    public void drawScore(Graphics g)
    {
        //drawing score and name and positioning them
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.setColor(Color.MAGENTA);
        g.drawString("SCORE : " + play.mySnake.score, 20, 40);
        g.drawString("NAME : " + startMenu.Username, 600, 40);
    }

    public void drawScore2(Graphics g)
    {
        //drawing score and name and positioning them
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.setColor(Color.MAGENTA);
        g.drawString("SCORE : " + wallsLevel.mySnake.score, 20, 40);
        g.drawString("NAME : " + startMenu.Username, 600, 40);
    }
}
