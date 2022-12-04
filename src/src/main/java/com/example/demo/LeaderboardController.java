package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LeaderboardController implements Initializable {
    @FXML
    private List<Label> labelList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Empty
    }

    public final Label getLabel(int i){
        return labelList.get(i);
    }
}
