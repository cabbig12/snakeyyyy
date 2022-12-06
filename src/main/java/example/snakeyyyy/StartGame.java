package example.snakeyyyy;

public class StartGame {

    static int i = 0;
    static int j = 0;

    static int e = 0;
    static EndMenu endMenu = new EndMenu();

    static boolean GameState = true;
    static int GameLevel;
    public static void startGame()
    {
        e++;
        if(e == 1){
            System.out.println("true");
            new Play().loadFrame();
            MusicPlayer.getMusicPlay("src/example/frogger.mp3");
        }

    }
    public static void StartWallsLevel(){
        j++;
        if (Play.mySnake.score > 500 && j == 1){
            WallsLevel.SetScore();
            new WallsLevel().loadFrame();
        }
    }

    public static void DrawEndMenu(){           // function to draw EndMenu frame

        // counter to ensure only one EndMenu frame is drawn
        i++;
        if(i == 1) {
            endMenu.EndMenu();
        }
    }
}
