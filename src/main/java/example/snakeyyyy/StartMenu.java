package example.snakeyyyy;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class StartMenu extends JFrame {
    StartGame StartGame;
    Image label = ImageUtil.images.get("start-menu-banner");
    Icon icon = new ImageIcon((Image) label);
    public StartMenu() {

        //defining panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();

        // defining background colors
        panel1.setBackground(Color.green);
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.green);
        panel4.setBackground(Color.green);

        //Defining enterName label
        JLabel EnterName = new JLabel("Enter Name: ");

        //Defining highscore labels
        JLabel HighScore1 = new JLabel("This is a label1");
        JLabel HighScore2 = new JLabel("This is a label2");
        JLabel HighScore3 = new JLabel("This is a label3");

        //defining snakeyyyy logo
        JLabel sticker = new JLabel(icon);
        
        //defining input text box
        JTextField textField = new JTextField(5);

        //making quit, submit and start button
        JButton submitButton = new JButton("Submit");
        JButton quitButton = new JButton("Exit");
        JButton StartButton = new JButton("Start");

        //styling highscore labels
        HighScore1.setFont(new Font("Verdana",1,20));
        HighScore2.setFont(new Font("Verdana",1,20));
        HighScore3.setFont(new Font("Verdana",1,20));


        //setting jpanels to boxlayout
        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.X_AXIS);
        BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
        BoxLayout layout4 = new BoxLayout(panel4, BoxLayout.Y_AXIS);
        panel1.setLayout(layout1);
        panel2.setLayout(layout2);
        panel3.setLayout(layout3);
        panel4.setLayout(layout4);

        //setting size of quit start and submit button
        StartButton.setMaximumSize( new Dimension( 350, 70 ) );
        quitButton.setMaximumSize( new Dimension( 350, 70 ) );
        submitButton.setMaximumSize( new Dimension(     80, 30 ) );
        textField.setMaximumSize(new Dimension( 150, 30 ));


        //adding functionality to start and quit button
        quitButton.addActionListener(e -> System.exit(0));
        StartButton.addActionListener(e -> StartGame.startGame());
        StartButton.addActionListener(e -> dispose());


        //adding snakeyyyy label to the 1st panel
        panel1.add(sticker);


        //adding text box to panel2
        panel2.add(EnterName);
        panel2.add(textField);
        panel2.add(submitButton);

        //adding start and quit button to the 3rd panel
        panel3.add(StartButton);
        panel3.add(quitButton);

        //adding highscore labels to the 3rd panel
        panel4.add(HighScore1);
        panel4.add(HighScore2);
        panel4.add(HighScore3);

        // Add the three panels into the frame
        setLayout(new GridLayout(4,1));
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);

        //positioning frame nicely
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 193, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(2, 150, 10, 50));
        panel3.setBorder(BorderFactory.createEmptyBorder(70, 120, 100, 100));
        panel4.setBorder(BorderFactory.createTitledBorder("HighScore"));

        StartButton.setVisible(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton.setVisible(false);
                StartButton.setVisible(true);
            }
        });

        pack();
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
