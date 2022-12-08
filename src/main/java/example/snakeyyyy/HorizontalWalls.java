package example.snakeyyyy;

import java.awt.*;

public class HorizontalWalls extends Snake.SnakeObject {

    public HorizontalWalls() {
        // method to draw horizontal walls
        this.l = true; // Status of life

        this.i = ImageUtil.images.get("Horizontal Wall"); // image initialised

        this.w = i.getWidth(null);  // width of wall variable
        this.h = i.getHeight(null); // height of wall variable

        this.x = (int) (Math.random() * (870 - w + 10));    // x coordinate
        this.y = (int) (Math.random() * (560 - h - 40));    // y coordinate
    }

    public void WallTouched(Snake.MySnake mySnake)	{

        // checking if food and snake objects touch and adding to the score and snake length if condition is met
        if (mySnake.getRectangle().intersects(this.getRectangle())  && mySnake.l)		{
            mySnake.changeLength(mySnake.getLength() - 3);

            // making snake life status false
            mySnake.l = false;

        }

    }
    @Override
    public void draw(Graphics g)
    {
        g.drawImage(i, x, y, null);
    }
}
