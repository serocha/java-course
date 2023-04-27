package com.example.contactschallenge;

import com.example.contactschallenge.datamodel.Contact;
import com.example.contactschallenge.datamodel.ContactData;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Optional;

public class AppController {
    @FXML
    private VBox mainVbox;
    @FXML
    private ContactData contactData = new ContactData();
    @FXML
    private TableView<ContactData> contactTable;
    @FXML
    private TableColumn<Contact, SimpleStringProperty> firstNameCol;
    @FXML
    private TableColumn<Contact, SimpleStringProperty> lastNameCol;
    @FXML
    private TableColumn<Contact, SimpleStringProperty> phoneNumCol;
    @FXML
    private TableColumn<Contact, SimpleStringProperty> notesCol;

    public void initialize() {
        // I found it quicker to set the columns to 25% width this way
        for (TableColumn column : contactTable.getColumns()){
            column.prefWidthProperty().bind(contactTable.widthProperty().divide(4));
        }

        contactData.loadContacts();
        contactTable.getItems().add(contactData);
    }
    @FXML
    public void showContactDialog() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("New Contact");
        dialog.setHeaderText("Create New Contact");
        showDialog(dialog);
    }

    public void showDialog(Dialog<ButtonType> dialog) {
        dialog.initOwner(mainVbox.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contact-dialog.fxml"));

        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();

            contactData.addContact(controller.createContact());
            contactData.saveContacts();
        }
    }
}