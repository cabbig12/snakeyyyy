package example.snakeyyyy;

public class StartGame {

    // counter for End Menu frame
    static int i = 0;

    // counter for 2nd level frame
    static int j = 0;

    // counter for 1st level frame
    static int e = 0;
    static EndMenu endMenu = new EndMenu();

    static boolean GameState = true;
    static int GameLevel;
    public static void startGame()
    {
        // Method to start 1st level
        e++;
        if(e == 1){
            System.out.println("true");
            new Play().loadFrame();
            MusicPlayer.getMusicPlay("src/example/frogger.mp3");
        }

    }
    public static void StartWallsLevel(){

        // Method to start 2nd level
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
