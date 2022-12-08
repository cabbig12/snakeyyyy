package example.snakeyyyy;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

public class LaunchSwingFromFX extends Application {

    //start button initialised
    Button launch = new Button("New Game: Green Theme");
    Button launch2 = new Button("New Game: Blue Theme");



    //root pane initialised
    StackPane root = new StackPane();

    //Scene initialised
    Scene scene = new Scene(root, 600, 377);

    //Pane for banner initialised
    Pane bannerPane = new Pane();

    //background image initialised and made into type ImageView
    Image background = new Image("example/snakebg.jpeg");
    ImageView backgroundView = new ImageView(background);
    //banner picture initialised and made into type ImageView
    Image banner = new Image("example/banner.jpg");
    ImageView bannerView = new ImageView(banner);

    @Override
    public void start(Stage primaryStage) {
        //method to create stage for launch frame

        Platform.setImplicitExit(false);

        launch.setOnAction(e -> {                       //making launch button load up StartMenu
            SwingUtilities.invokeLater(StartMenu::new);
            primaryStage.hide();
        });

        launch2.setOnAction(e -> {                       //making launch button load up StartMenu
            SwingUtilities.invokeLater(StartMenuBlue::new);
            primaryStage.hide();
        });

        // styling screen method called
        LaunchScreenStyling();

        //adding scene to stage
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void LaunchScreenStyling(){

        //adding labels panes and buttons to scene
        bannerPane.getChildren().add(bannerView);
        root.getChildren().add(backgroundView);
        root.getChildren().add(bannerPane);
        root.getChildren().add(launch);
        root.getChildren().add(launch2);
        bannerPane.setId("banner");

        //position 2nd button
        launch2.setTranslateX(0);
        launch2.setTranslateY(30);




    }

    public static void main(String[] args) {
        launch(args);
    }
}
