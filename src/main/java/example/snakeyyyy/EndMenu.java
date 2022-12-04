package example.snakeyyyy;

import javax.swing.*;
import java.awt.*;

public class EndMenu extends JFrame {
    //Initialising Background image
    public Image fail = ImageUtil.images.get("game-scene-01");

    //Initialising jpanel
    JPanel panel1 = new JPanel();

    //Initialising Exit button and play again button
    JButton ExitButton = new JButton("Exit");
    JButton PlayAgainButton = new JButton("Play Again");

    JLabel bg = new JLabel(new ImageIcon(fail));

    public void EndMenu(){
        DesignMenu();
    }

    public void DesignMenu(){

        BoxLayout layout1 = new BoxLayout(panel1, BoxLayout.X_AXIS);
        panel1.setLayout(layout1);

        panel1.add(bg);
        panel1.add(PlayAgainButton);
        panel1.add(ExitButton);

        pack();
        setVisible(true);
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void AddFunctionality(){

    }
}
