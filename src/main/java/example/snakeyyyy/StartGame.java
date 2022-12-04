package example.snakeyyyy;

public class StartGame {

    static int i = 0;
    static EndMenu endMenu = new EndMenu();
    public static void startGame()
    {
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/example/frogger.mp3");

    }

    public static void DrawEndMenu(){
        i++;
        if(i == 1) {
            endMenu.EndMenu();
        }
    }
}
