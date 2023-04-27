module com.example.contactschallenge {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens com.example.contactschallenge to javafx.fxml;
    exports com.example.contactschallenge;
    exports com.example.contactschallenge.datamodel;
    opens com.example.contactschallenge.datamodel to javafx.fxml;
}