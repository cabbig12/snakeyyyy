package example.snakeyyyy;

public class StartGame {

    static int i = 0;
    static EndMenu endMenu = new EndMenu();
    public static void startGame()
    {
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/example/frogger.mp3");

    }

    public static void DrawEndMenu(){           // function to draw EndMenu frame

        // counter to ensure only one EndMenu frame is drawn
        i++;
        if(i == 1) {
            endMenu.EndMenu();
        }
    }
}
