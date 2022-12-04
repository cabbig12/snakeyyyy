package example.snakeyyyy;

import javax.swing.*;
import java.awt.*;

public class EndMenu extends JFrame {
    //Initialising Background image
    public Image fail = ImageUtil.images.get("game-scene-01");

    Play play = new Play();

    Snake.MySnake snake;
    //Initialising jpanel
    JLabel bg = new JLabel(new ImageIcon(fail));

    //Initialising Exit button and play again button
    JButton ExitButton = new JButton("Exit");
    JButton PlayAgainButton = new JButton("Play Again");


    public void EndMenu(){
        DesignMenu();


    }

    public void DesignMenu(){

        BoxLayout layout1 = new BoxLayout(bg, BoxLayout.Y_AXIS);
        bg.setLayout(layout1);

        bg.add(PlayAgainButton);
        bg.add(ExitButton);


        this.add(bg);


        pack();
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);

    }

    public void AddFunctionality(){

    }


}
