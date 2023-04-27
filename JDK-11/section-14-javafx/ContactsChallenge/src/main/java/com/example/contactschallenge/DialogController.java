package com.example.contactschallenge;

import com.example.contactschallenge.datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DialogController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phoneNum;
    @FXML
    private TextArea notes;

    public Contact createContact() {
        return new Contact(firstName.getText(), lastName.getText(), phoneNum.getText(), notes.getText());
    }
}
