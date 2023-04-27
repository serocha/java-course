module com.example.stylingjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens com.example.stylingjavafx to javafx.fxml;
    exports com.example.stylingjavafx;
}