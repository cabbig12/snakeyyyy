package example.snakeyyyy;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartMenu extends JFrame {

    public StartMenu() {
        setLayout(new BorderLayout());
        add(new JLabel("Snakeyyyy", JLabel.CENTER), BorderLayout.CENTER);
        JButton newGame = new JButton("New Game");
        JButton quitButton = new JButton("Exit");
        quitButton.addActionListener(e -> System.exit(0));
        quitButton.addActionListener(e -> new StartGame());
        add(newGame, BorderLayout.EAST);
        add(quitButton, BorderLayout.SOUTH);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
