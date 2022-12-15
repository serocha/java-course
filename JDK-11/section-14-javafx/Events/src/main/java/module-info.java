module com.udemy.events {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.udemy.events to javafx.fxml;
    exports com.udemy.events;
}