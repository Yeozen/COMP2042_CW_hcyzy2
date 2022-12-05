package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LeaderboardController implements Initializable {
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

    public void returntomenu() throws IOException {
        Stage leaderboard_stage = (Stage) returntomenu.getScene().getWindow();
        leaderboard_stage.close();
        Parent pane;
        final FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        pane = loader.load();
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(pane,600,500));
    }
}
