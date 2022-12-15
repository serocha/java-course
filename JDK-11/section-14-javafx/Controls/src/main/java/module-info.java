module com.udemy.controls {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.udemy.controls to javafx.fxml;
    exports com.udemy.controls;
}