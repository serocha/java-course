package com.example.stylingjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class AppController {
    @FXML
    private GridPane gridPane;
    @FXML
    private Label label;
    @FXML
    private Button buttonFour;

    public void initialize() {
        buttonFour.setEffect(new DropShadow());
    }

    @FXML
    public void handleMouseEnter() {
        label.setScaleX(2.0);
        label.setScaleY(2.0);
        //label.setRotate(90.0);
    }

    @FXML
    public void handleMouseExit() {
        label.setScaleX(1.0);
        label.setScaleY(1.0);
        //label.setRotate(0.0);
    }

    @FXML
    public void handleClicked() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Open File");
        // filters are particularly useful for opening files, as they hide (or mute) files without that extension
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text", "*.txt"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        //DirectoryChooser chooser = new DirectoryChooser();
        //chooser.showDialog(gridPane.getScene().getWindow()); // pass the GridPane window to make it modal
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if (file != null) {
            for (int i=0; i< file.size(); i++) {
                System.out.println(file.get(i));
            }
            //System.out.println(file.getPath());
        } else {
            System.out.println("Chooser was cancelled");
        }
    }

    @FXML
    public void handleLinkClicked() {
        System.out.println("Link was clicked");
        // use default browser
        try {
            Desktop.getDesktop().browse(new URI("https://openjfx.io/"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
}