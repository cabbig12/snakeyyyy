package example.snakeyyyy;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartMenu extends JFrame {
    StartGame StartGame;
    Image label = ImageUtil.images.get("start-menu-banner");
    public StartMenu() {
        setLayout(new BorderLayout());
        add(new JLabel("Snakeyyyy", (JLabel.CENTER)), BorderLayout.CENTER);
        JButton StartButton = new JButton("Start:");
        JButton quitButton = new JButton("Exit");
        quitButton.addActionListener(e -> System.exit(0));
        StartButton.addActionListener(e -> StartGame.startGame());
        add(StartButton, BorderLayout.EAST);
        add(quitButton, BorderLayout.SOUTH);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.BLUE);
    }
}
