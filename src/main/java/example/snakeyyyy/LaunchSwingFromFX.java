package example.snakeyyyy;

import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LaunchSwingFromFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        Platform.setImplicitExit(false);

        Button launch = new Button("New Game");
        launch.setOnAction(e -> {
            SwingUtilities.invokeLater(StartMenu::new);
            primaryStage.hide();
        });
        StackPane root = new StackPane(launch);
        Scene scene = new Scene(root, 800, 500);

        scene.setFill(Color.web("#81c483"));

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void LaunchScreenStyling(){


    }

    public static void main(String[] args) {
        launch(args);
    }
}
