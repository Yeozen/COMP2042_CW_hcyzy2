package com.example.demo.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * LeaderboardController handles everything dealing with the leaderboard.fxml
 * @author Zen Yeo
 */
public class LeaderboardController implements Initializable {

    @FXML
    private Button returntomenu;

    @FXML
    private List<Label> labelList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Empty
    }

    /**
     * method to obtain the labels in the arraylist in leaderboard.fxml
     * @param i value i to act as an index to access the array of labels
     * @return the said label indexed by the i value
     */
    public final Label getLabel(int i){
        return labelList.get(i);
    }

    /**
     * method that closes the leaderboard window
     */
    public void returntomenu() {
        Stage leaderboard_stage = (Stage) returntomenu.getScene().getWindow();
        leaderboard_stage.close();
    }
}
