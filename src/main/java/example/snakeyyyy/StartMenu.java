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

        BoxLayout boxlayout = new BoxLayout(panel1, BoxLayout.Y_AXIS);

        panel1.setLayout(boxlayout);
        panel1.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        JButton StartButton = new JButton("Start: --------");
        JButton quitButton = new JButton("Exit--------");
        quitButton.addActionListener(e -> System.exit(0));
        StartButton.addActionListener(e -> StartGame.startGame());

        panel1.add(sticker);

        panel2.add(StartButton);
        panel2.add(quitButton);

        add(panel1);
        add(panel2);
        pack();
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.BLUE);
    }
}
