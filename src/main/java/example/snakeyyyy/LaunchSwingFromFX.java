package example.snakeyyyy;

import javax.swing.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LaunchSwingFromFX extends Application {

    //start button initialised
    Button launch = new Button("New Game");

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

        Platform.setImplicitExit(false);

        launch.setOnAction(e -> {                       //making launch button load up StartMenu
            SwingUtilities.invokeLater(StartMenu::new);
            primaryStage.hide();
        });

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
        bannerPane.setId("banner");
        bannerPane.getStyleClass().add("/example/stylesheet.css");


    }

    public static void main(String[] args) {
        launch(args);
    }
}
