package com.example.scenebuilder;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AppController {

    @FXML
    private Label label;

    @FXML
    public void handleAction() {
        label.setText("OK Button Pressed");
    }
}