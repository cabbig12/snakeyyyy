package example.snakeyyyy;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StartMenu extends JFrame {
    StartGame StartGame;
    Image label = ImageUtil.images.get("start-menu-banner");
    Icon icon = new ImageIcon((Image) label);
    public StartMenu() {

        //defining panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        JLabel sticker = new JLabel(icon);

        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.X_AXIS);
        panel1.setLayout(layout1);
        panel2.setLayout(layout2);
        panel3.setLayout(layout3);

        JButton StartButton = new JButton("Start: --------");
        JButton quitButton = new JButton("Exit--------");
        quitButton.addActionListener(e -> System.exit(0));
        StartButton.addActionListener(e -> StartGame.startGame());

        panel1.add(sticker);

        panel2.add(StartButton);
        panel2.add(quitButton);


        // Add the three panels into the frame
        setLayout(new GridLayout(3,1));
        add(panel1);
        add(panel2);
        add(panel3);

        panel1.setBorder(BorderFactory.createEmptyBorder(10, 200, 10, 10));
        panel2.setBorder(BorderFactory.createEmptyBorder(70, 220, 100, 100));


        pack();
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
    }
}
