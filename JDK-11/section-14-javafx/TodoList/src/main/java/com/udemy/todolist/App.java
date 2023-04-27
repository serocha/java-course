package com.udemy.todolist;

/*      Simple To-Do List application
 *      UI will be functional, but not very aesthetic. The code isn't comprehensive, and there are a
 *      few shortcuts that wouldn't be used in a real-world application.
 *      Controller could use better encapsulation and refactoring to reduce some duplicate code
 *      App currently does no validation of user input, which would affect how sorting is performed
 */

import com.udemy.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("To-Do List");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Saving...");
        // save
        try {
            TodoData.getInstance().storeTodoItems(); // getInstance() from singleton methods (static, private const())
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Exiting...");
    }

    @Override
    public void init() throws Exception {
        System.out.println("Initializing...");
        try {
            TodoData.getInstance().loadTodoItems();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Loading complete");
    }
}