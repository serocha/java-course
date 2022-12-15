package com.udemy.events;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    private TextField nameField;
    @FXML

    private Button helloButton;
    @FXML
    private Button goodbyeButton;
    @FXML
    private CheckBox clearField;
    @FXML
    private Label simulatedData;

    @FXML
    public void initialize() {
        // automatically called when app is initialized
        helloButton.setDisable(true);
        goodbyeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e) {

        if (e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText() + "!");
        } else if (e.getSource().equals(goodbyeButton)) {
            System.out.println("Goodbye, " + nameField.getText() + ".");
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(5000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            // Platform takes a Runnable
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating the label on the: " + s);
                            simulatedData.setText("Data retrieved!");
                        }
                    });
                } catch (InterruptedException event) {
                    // simulating a long event handler locking up the thread
                }
            }
        };
        new Thread(task).start(); // have to initialize the task

        if (clearField.isSelected()) {
            nameField.clear();
            helloButton.setDisable(true);
            goodbyeButton.setDisable(true);
        }
    }

    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty(); // ignoring whitespace
        helloButton.setDisable(disableButtons);
        goodbyeButton.setDisable(disableButtons);
    }
}