package com.example.demo;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Objects;
import java.util.Optional;
import static com.example.demo.Controller.*;
import static javafx.scene.paint.Color.BLACK;


public class EndGame {
    private static EndGame singleInstance = null;
    private Scene gameScene;

    private EndGame() {

    }

    public static EndGame getInstance() {
        if (singleInstance == null)
            singleInstance = new EndGame();
        return singleInstance;
    }

    public void setGameRoot(Group gameRoot) {
        Controller.setGameRoot(gameRoot);
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public Group endgameRoot = new Group();


    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage, long score){
        Text text = new Text("GAME OVER");
        text.relocate(250, 250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        Text scoreText = new Text("SCORE: " + score);
        scoreText.setFill(BLACK);
        scoreText.relocate(370, 350);
        scoreText.setFont(Font.font(40));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100, 30);
        quitButton.setTextFill(BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(300, 500);
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    root.getChildren().clear();
                    System.exit(0);
                }
            }
        });

        Button restartButton = new Button("RESTART");
        restartButton.setPrefSize(100, 30);
        restartButton.setTextFill(BLACK);
        root.getChildren().add(restartButton);
        restartButton.relocate(500, 500);
        restartButton.setOnMouseClicked(new EventHandler<>() {
            @Override
            public void handle(MouseEvent event) {
                Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
                backgroundOfMenu.setX(WIDTH / 2 - 120);
                backgroundOfMenu.setY(180);

                Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
                backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
                backgroundOfMenuForPlay.setY(180);

                Stage game_stage = new Stage();
                game_stage.setTitle("2048");
                Group gameRoot = new Group();
                setGameRoot(gameRoot);

                if (Objects.equals(colour_picked, "YELLOW")){
                    gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
                } else if (Objects.equals(colour_picked, "RED")) {
                    gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(125, 28, 0));
                } else if (Objects.equals(colour_picked, "PURPLE")) {
                    gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(100, 100, 255));
                } else {
                    gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
                }

                if (Objects.equals(board_size, "3x3")){
                    GameScene.setN(3);
                } else if (Objects.equals(board_size, "4x4")){
                    GameScene.setN(4);
                } else if (Objects.equals(board_size, "5x5")){
                    GameScene.setN(5);
                } else {
                    GameScene.setN(4);
                }
                setGameScene(gameScene);
                game_stage.setScene(gameScene);
                GameScene game = new GameScene();
                game.game(gameScene, gameRoot, game_stage, endGameScene, endgameRoot);
                game_stage.show();
                Stage end_stage = (Stage) restartButton.getScene().getWindow();
                end_stage.close();
            }
        });
    }
}