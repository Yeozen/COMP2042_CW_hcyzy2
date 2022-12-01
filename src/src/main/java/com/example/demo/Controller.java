package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class Controller {
    static final int WIDTH = 900;
    static final int HEIGHT = 700;
    private static Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    public Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

    @FXML
    private ChoiceBox<String> colour_picker;

    @FXML
    private TextField user_name;

    @FXML
    private ChoiceBox<String> game_type;

    @FXML
    public Button StartButton;

    @FXML
    public Button LeaderboardButton;

    public static String colour_picked;
    public static String board_size;
    public static String userName;

    public static void setGameRoot(Group gameRoot) {
        Controller.gameRoot = gameRoot;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void startGame(){

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

        userName = user_name.getText();

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
        Stage menu_stage = (Stage) StartButton.getScene().getWindow();
        menu_stage.close();
        game_stage.show();
    }

    @FXML
    void pick_colour() {
        colour_picked = colour_picker.getValue();
    }

    @FXML
    void set_gametype() {
        board_size = game_type.getValue();
    }

    public void show_leaderboard() {
    }
}
