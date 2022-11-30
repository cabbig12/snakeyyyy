package example.snakeyyyy;

public class StartGame {
    public static void startGame()
    {
        new Play().loadFrame();
        MusicPlayer.getMusicPlay("src/example/frogger.mp3");


    }
}
