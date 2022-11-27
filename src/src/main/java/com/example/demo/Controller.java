package com.example.demo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Objects;


public class Controller {
    static final int WIDTH = 900;
    static final int HEIGHT = 700;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    Group endgameRoot = new Group();
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

    @FXML
    private ChoiceBox<String> colour_picker;

    @FXML
    private ChoiceBox<String> game_type;

    private String colour_picked;
    private String board_size;

    public Button StartButton;

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void handleButtonClick(ActionEvent event){

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
        System.out.println(colour_picked);
        if (Objects.equals(colour_picked, "YELLOW")){
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        } else if (Objects.equals(colour_picked, "GREEN")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(125, 20, 0));
        } else if (Objects.equals(colour_picked, "PURPLE")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(100, 100, 255));
        } else {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
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
    void pick_colour(ActionEvent event) {
        colour_picked = colour_picker.getValue();
    }

    @FXML
    void set_gametype(ActionEvent event) {
        board_size = game_type.getValue();
        if (Objects.equals(board_size, "3x3")){
            GameScene.n = 3;
        } else if (Objects.equals(board_size, "4x4")){
            GameScene.n = 4;
        } else if (Objects.equals(board_size, "5x5")){
            GameScene.n = 5;
        }

    }
}
