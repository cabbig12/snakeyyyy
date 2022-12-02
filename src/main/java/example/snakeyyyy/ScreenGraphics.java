package example.snakeyyyy;

import java.awt.*;


public class ScreenGraphics extends Play {

    public Image background = ImageUtil.images.get("UI-background");
    public Image fail = ImageUtil.images.get("game-scene-01");
    public StartMenu startMenu;

    public void drawScore(Graphics g)
    {
        //drawing score and name and positioning them
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        g.setColor(Color.MAGENTA);
        g.drawString("SCORE : " + mySnake.score, 20, 40);
        g.drawString("NAME : " + startMenu.Username, 600, 40);
    }
}
