package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static com.example.demo.Main.root;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class LeaderboardController implements Initializable {
    static Group menuRoot;
    @FXML
    private Button returntomenu;

    @FXML
    private List<Label> labelList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Empty
    }

    public final Label getLabel(int i){
        return labelList.get(i);
    }

    public static Parent getRoot() {
        return root;
    }

    public void returntomenu() throws IOException {
        Stage leaderboard_stage = (Stage) returntomenu.getScene().getWindow();
        leaderboard_stage.close();
    }
}
