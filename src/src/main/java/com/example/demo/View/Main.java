package com.example.demo.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * Main class contains the methods to begin the game
 */
public class Main extends Application {
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/resources/menu.fxml")));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    /**
     * starts the application
     * @param args takes in the argument
     */
    public static void main(String[] args) {
        launch(args);
    }
}
