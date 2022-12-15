module com.udemy.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.udemy.todolist to javafx.fxml;
    exports com.udemy.todolist;
}