package example.snakeyyyy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

public class Snake {
	
		private static final long serialVersionUID = -3641221053272056036L;


    // TODO: það þarf endurnýjun

    public static Food food = new Food();
    public static Play play = new Play();

    public static int moving;

    public static int move(int x) {
        moving = x;
        return moving;
    }


    public static class MySnake extends SnakeObject implements movable
{
    // Snake properties initialised
    private float speed_XY;
    private int length;
    private float num; // ?
    public int score = 0;


    private static final BufferedImage IMG_SNAKE_HEAD = (BufferedImage) ImageUtil.images.get("snake-head-right");

    public static List<Point> bodyPoints = new LinkedList<>();

    private static BufferedImage newImgSnakeHead;
    boolean up, down, left, right = true;

    public MySnake(int x, int y)
    {
        this.l = true;
        this.x = x;
        this.y = y;
        this.i = ImageUtil.images.get("snake-body");
        this.w = i.getWidth(null);
        this.h = i.getHeight(null);

        this.speed_XY = 5;
        this.length = 1;

        /*
         * Attention : ?
         */
        this.num = w / speed_XY;
        newImgSnakeHead = IMG_SNAKE_HEAD;

    }

    public int getLength()
    {
        return length;
    }

    public void changeLength(int length)
    {
        this.length = length;
    }

    public void keyPressed(KeyEvent e)
    {
        // All keyboard control of the snake managed here
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                if (!down)
                {
                    up = true;
                    down = false;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                }
                break;

            case KeyEvent.VK_DOWN:
                if (!up)
                {
                    up = false;
                    down = true;
                    left = false;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                }
                break;

            case KeyEvent.VK_LEFT:
                if (!right)
                {
                    up = false;
                    down = false;
                    left = true;
                    right = false;

                    newImgSnakeHead = (BufferedImage) GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);

                }
                break;

            case KeyEvent.VK_RIGHT:
                if (!left)
                {
                    up = false;
                    down = false;
                    left = false;
                    right = true;

                    newImgSnakeHead = IMG_SNAKE_HEAD;
                }

            default:
                break;
        }
    }

    public void ChangeSpeed(){
        // method to increase speed as snake eats more food
        if(this.speed_XY < 12){
            this.speed_XY = (float) (this.speed_XY + 0.6);
        }
    }


    public void move()
    {
        // adding value to the relative axis depending on key pressed
        if (up)
        {
            y -= speed_XY;
        } else if (down)
        {
            y += speed_XY;
        } else if (left)
        {
            x -= speed_XY;
        } else if (right)
        {
            x += speed_XY;
        }

    }

    @Override
    public void draw(Graphics g)
    {
        outofBounds();
        eatBody();

        bodyPoints.add(new Point(x, y));

        if (bodyPoints.size() == (this.length + 1) * num)
        {
            bodyPoints.remove(0);
        }
        g.drawImage(newImgSnakeHead, x, y, null);
        drawBody(g);

        move();
    }

    public void eatBody()
    {
        for (Point point : bodyPoints)
        {
            for (Point point2 : bodyPoints)
            {
                if (point != point2 && point.distance(point2) < 5)
                {
                    this.l = false;

                }
            }
        }
    }

    public void drawBody(Graphics g)
    {
        float length = bodyPoints.size() - 1 - num;

        for (float i = length; i >= num; i -= num)
        {
            Point point = bodyPoints.get((int) i);
            g.drawImage(this.i, point.x, point.y, null);
        }
    }

    private void outofBounds()
    {
        boolean xOut = (x <= 0 || x >= (890 - w));
        boolean yOut = (y <= 0 || y >= (560 - h));
        if (xOut || yOut)
        {
            l = false;
        }
    }
}

public abstract static class SnakeObject
{
    int x;
    int y;
    Image i;
    int w;
    int h;

    public boolean l;


    public abstract void draw(Graphics g);

    public Rectangle getRectangle()
    {
        return new Rectangle(x, y, w, h);
    }
}
}