package com.example.contactschallenge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Contacts");
        stage.setScene(scene);

        // save contacts when closing
//        AppController controller = fxmlLoader.getController();
//        stage.setOnCloseRequest(e -> {
//            controller.exit();
//        });
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}