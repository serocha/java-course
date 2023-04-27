package com.udemy.todolist;

import com.udemy.todolist.datamodel.TodoData;
import com.udemy.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;
    @FXML
    private TextArea detailsArea;
    @FXML
    private DatePicker deadlinePicker;

    @FXML
    public TodoItem processResult() {
        TodoItem item = populateItem();
        TodoData.getInstance().addTodoItem(item); // update state
        return item;
    }

    @FXML
    public TodoItem editResult(TodoItem existingItem) {
        TodoItem item = populateItem();
        TodoData.getInstance().removeTodoItem(existingItem); // update state
        TodoData.getInstance().addTodoItem(item);
        return item;
    }

    private TodoItem populateItem() {
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();
        return new TodoItem(shortDescription, details, deadlineValue);
    }

    @FXML
    public void loadExistingEvent(TodoItem item) {
        shortDescriptionField.setText(item.getShortDescription());
        detailsArea.setText(item.getDetails());
        deadlinePicker.setValue(item.getDeadline());
    }
}
