package example.snakeyyyy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndMenu extends JFrame {


    //Initialising Background image
    public Image fail = ImageUtil.images.get("game-scene-01");
    StartMenu StartMenu = new StartMenu();

    Play play = new Play();

    Snake.MySnake snake;
    //Initialising jlabel for background
    JLabel bg = new JLabel(new ImageIcon(fail));

    //Initialising Exit button and play again button
    JButton ExitButton = new JButton("Exit");
    JButton PlayAgainButton = new JButton("Play Again");


    public void EndMenu(){

        //method to fully design and implement end menu features
        DesignMenu();
        AddFunctionality();


    }

    public void DesignMenu(){

        // defining layout of end menu
        BoxLayout layout1 = new BoxLayout(bg, BoxLayout.Y_AXIS);
        bg.setLayout(layout1);

        //adding buttons to the screen
        bg.add(PlayAgainButton);
        bg.add(ExitButton);


        //adding jlabel to the jframe
        this.add(bg);


        //screen settings
        pack();
        setVisible(true);
        setSize(600, 315);
        setLocationRelativeTo(null);

    }

    public void AddFunctionality(){
        //adding functionality to start and quit button
        ExitButton.addActionListener(e -> System.exit(0));
        PlayAgainButton.addActionListener(e -> new StartMenu());
        PlayAgainButton.addActionListener(e -> dispose());

    }


}
