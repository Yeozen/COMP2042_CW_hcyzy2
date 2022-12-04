package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
<<<<<<< Updated upstream
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
=======
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.*;
import javafx.stage.Modality;
>>>>>>> Stashed changes
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

<<<<<<< Updated upstream
=======
import static com.example.demo.Account.*;

>>>>>>> Stashed changes

public class Controller {
    static final int WIDTH = 900;
    static final int HEIGHT = 700;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
<<<<<<< Updated upstream
    Group endgameRoot = new Group();
=======
    private static Group leaderboardRoot = new Group();
    private Scene leaderboardScene = new Scene(leaderboardRoot, WIDTH, HEIGHT, Color.rgb(1, 177, 92));
    public Group endgameRoot = new Group();
>>>>>>> Stashed changes
    Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

    @FXML
    private Pane pane1;

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

<<<<<<< Updated upstream
    public void handleButtonClick(ActionEvent event){
=======
    public static void setLeaderboardRoot(Group gameRoot) {
        Controller.leaderboardRoot = leaderboardRoot;
    }

    public void setLeaderboardScene(Scene gameScene) {
        this.leaderboardScene = leaderboardScene;
    }


    public void startGame(){
>>>>>>> Stashed changes

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
        System.out.println("cocksucker: "+colour_picked);

        if (Objects.equals(colour_picked, "YELLOW")){
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
        } else if (Objects.equals(colour_picked, "RED")) {
            gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(125, 20, 0));
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
    void pick_colour(ActionEvent event) {
        colour_picked = colour_picker.getValue();
    }

    @FXML
    void set_gametype(ActionEvent event) {
        board_size = game_type.getValue();
<<<<<<< Updated upstream
        if (Objects.equals(board_size, "3x3")){
            GameScene.setN(3);
        } else if (Objects.equals(board_size, "4x4")){
            GameScene.setN(4);
        } else if (Objects.equals(board_size, "5x5")){
            GameScene.setN(5);
        } else {
            GameScene.setN(4);
        }
=======
    }

    public void show_leaderboard(ActionEvent event) throws IOException {
        populateArray();
        int label = 0;
        Parent pane;
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("leaderboard.fxml"));
        pane = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(pane,600,900));
        //pane1.getChildren().setAll(pane);
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 2; j++){
                ((LeaderboardController) loader.getController()).getLabel(label).setText(LeaderboardArray[i][j]);
                System.out.println(LeaderboardArray[i][j]);
                label++;
            }
        }
        stage.show();
        /*Stage leaderboard_stage = new Stage();
        leaderboard_stage.setTitle("leaderboard");
        setLeaderboardRoot(leaderboardRoot);
        setLeaderboardScene(leaderboardScene);
        leaderboard_stage.setScene(leaderboardScene);
        Account leaderboard = new Account();
        leaderboard.leaderboard(leaderboardScene, leaderboardRoot, leaderboard_stage);
        leaderboard_stage.show();*/
>>>>>>> Stashed changes
    }
}
