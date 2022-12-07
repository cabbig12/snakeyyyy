package example.snakeyyyy;

import java.awt.*;

public class VerticalWalls extends Snake.SnakeObject {

    public VerticalWalls(){
        // method to draw vertical walls
        this.l = true;

        this.i = ImageUtil.images.get("Vertical Wall");

        this.w = i.getWidth(null);
        this.h = i.getHeight(null);

        this.x = (int) (Math.random() * (870 - w + 10));
        this.y = (int) (Math.random() * (560 - h - 40));

    }

    public void WallTouched(Snake.MySnake mySnake)	{

        // checking if food and snake objects touch and adding to the score and snake length if condition is met
        if (mySnake.getRectangle().intersects(this.getRectangle())  && mySnake.l)		{
            mySnake.changeLength(mySnake.getLength() - 3);

            mySnake.l = false;

        }

    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(i, x, y, null);
    }
}

