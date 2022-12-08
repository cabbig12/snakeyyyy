package example.snakeyyyy;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class StartMenu extends JFrame {

    public static Snake.MySnake mySnake = new Snake.MySnake(100, 100);// x , y
    StartGame StartGame;
    Image label = ImageUtil.images.get("start-menu-banner");
    Icon icon = new ImageIcon((Image) label);

    String csvFile = "src/main/resources/example/highscore.csv";

    Play play;

    //defining panels
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    static JPanel panel4 = new JPanel();

    //Defining enterName label
    JLabel EnterName = new JLabel("Enter Name: ");

    //Defining username
    static String Username = "hello";

    //Defining highscore labels
    JLabel HighScore1 = new JLabel(Username);
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

    public static final String delimiter = ",";

    int counter = 1;
    boolean state = true;

    public StartMenu() {

        if(state){
            if (counter == 1){
                styleStartMenu();
                addStartMenuObjects();
                startMenuObjectFunctionality();
                counter++;}

            if(counter == 3){
                this.setVisible(false);
                counter++;
            }
        }



    }

    private void styleStartMenu(){
        // defining background colors
        panel1.setBackground(Color.green);
        panel2.setBackground(Color.green);
        panel3.setBackground(Color.green);
        panel4.setBackground(Color.green);

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

        //positioning frame nicely
        panel1.setBorder(BorderFactory.createEmptyBorder(10, 193, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(2, 150, 10, 50));
        panel3.setBorder(BorderFactory.createEmptyBorder(70, 120, 100, 100));
        panel4.setBorder(BorderFactory.createTitledBorder("HighScore"));

        // screen settings
        pack();
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addStartMenuObjects(){


        //adding snakeyyyy label to the 1st panel
        panel1.add(sticker);


        //adding text box to panel2
        panel2.add(EnterName);
        panel2.add(textField);
        panel2.add(submitButton);

        //adding start and quit button to the 3rd panel
        panel3.add(StartButton);
        panel3.add(quitButton);

        //adding highscore labels to the 4th panel
        read(csvFile);

        // Add the three panels into the frame
        setLayout(new GridLayout(4,1));
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
    }

    private void startMenuObjectFunctionality(){

        //adding functionality to start and quit button
        quitButton.addActionListener(e -> System.exit(0));
        StartButton.addActionListener(e -> Play.mySnake.l = true);
        StartButton.addActionListener(e -> StartGame.GameLevel = 1);
        StartButton.addActionListener(e -> counter = 3);
        StartButton.addActionListener(e -> dispose());
        StartButton.addActionListener(e -> StartGame.startGame());



        // Setting start button to be invisible
        StartButton.setVisible(false);


        // making start button visible once submit button gets pressed
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitButton.setVisible(false);
                StartButton.setVisible(true);

                //Adding string
                StartMenu.Username = textField.getText();;

            }
        });

    }

    private static void read(String csvFile) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                for (String tempStr: tempArr) {
                    JLabel scoree =  new JLabel(tempStr);
                    panel4.add(scoree);
                }

            }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
