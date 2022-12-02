package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static com.example.demo.Account.LeaderboardArray;
import static com.example.demo.Account.lengthOfFile;


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

    public void show_leaderboard() throws IOException {
        String family = "Helvetica";
        double size = 50;

        TextFlow textFlow = new TextFlow();
        textFlow.setLayoutX(40);
        textFlow.setLayoutY(40);
        Text text1 = new Text("Hello ");
        text1.setFont(Font.font(family, size));
        text1.setFill(Color.RED);
        Text text2 = new Text("Bold");
        text2.setFill(Color.ORANGE);
        text2.setFont(Font.font(family, FontWeight.BOLD, size));
        Text text3 = new Text(" World");
        text3.setFill(Color.GREEN);
        text3.setFont(Font.font(family, FontPosture.ITALIC, size));
        textFlow.getChildren().addAll(text1, text2, text3);

        Stage stage = new Stage();
        Group group = new Group(textFlow);
        Scene scene = new Scene(group, 500, 150, Color.WHITE);
        stage.setTitle("Hello Rich Text");
        stage.setScene(scene);
        stage.show();
        int vert = 250;
        int hori = 250;
        for (int i = 0; i < lengthOfFile()/2; i++) {
            for (int j = 0; j < 2; j++) {
                Text text = new Text(LeaderboardArray[i][j]);
                text2.relocate(vert, hori);
                text2.setFont(Font.font(80));
                text2.setText(String.valueOf(text2));
                hori+=50;
            }
            vert+=50;
        }
        stage.show();
    }
}
