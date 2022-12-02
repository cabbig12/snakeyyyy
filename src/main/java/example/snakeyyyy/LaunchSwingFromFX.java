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


    @Override
    public void start(Stage primaryStage) {

        Platform.setImplicitExit(false);
        Label label = new Label("this is StackPane example");

        Button launch = new Button("New Game");
        launch.setOnAction(e -> {
            SwingUtilities.invokeLater(StartMenu::new);
            primaryStage.hide();
        });
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 600, 377);

        Pane bannerPane = new Pane();



        Image background = new Image("example/snakebg.jpeg");
        Image banner = new Image("example/banner.jpg");
        ImageView backgroundView = new ImageView(background);
        ImageView bannerView = new ImageView(banner);

        bannerPane.getChildren().add(bannerView);

        root.getChildren().add(backgroundView);
        root.getChildren().add(bannerPane);
        root.getChildren().add(launch);

        bannerPane.getStyleClass().add("/example/stylesheet.css");

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void LaunchScreenStyling(){


    }

    public static void main(String[] args) {
        launch(args);
    }
}
