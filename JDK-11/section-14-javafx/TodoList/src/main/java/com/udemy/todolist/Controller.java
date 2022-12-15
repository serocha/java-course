package com.udemy.todolist;

import com.udemy.todolist.datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;

    public void initialize() {
        TodoItem todoItem1 = new TodoItem("Lunch with Bill",
                "Set up a time and place to meet with Bill about his new goat.",
                LocalDate.of(2022, Month.DECEMBER, 20));
        TodoItem todoItem2 = new TodoItem("Doctor's appointment",
                "Go to Doc Brown's office to discuss temporal side effects. Mention the DeLorean.",
                LocalDate.of(2023, Month.JANUARY, 14));
        TodoItem todoItem3 = new TodoItem("Cliff diving party",
                "Celebrate Cindy's birthday party at Abiquiu Lake. Might want to ask her about low water level.",
                LocalDate.of(2023, Month.FEBRUARY, 3));
        TodoItem todoItem4 = new TodoItem("Competitive Bingo club meeting",
                "Set up the garage for the Bingo tournament. Bring extra salt.",
                LocalDate.of(2023, Month.FEBRUARY, 9));
        TodoItem todoItem5 = new TodoItem("Shady business deal",
                "Meet the weird man under the overpass to receive the package. Drop it off at the post office.",
                LocalDate.of(2023, Month.FEBRUARY, 19));

        todoItems = new ArrayList<TodoItem>();
        todoItems.add(todoItem1);
        todoItems.add(todoItem2);
        todoItems.add(todoItem3);
        todoItems.add(todoItem4);
        todoItems.add(todoItem5);

        // initialize a listener
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            // not using lambda's because we haven't covered them yet, implement old anonymous class method override
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem(); // get the current selection
                    itemDetailsTextArea.setText(item.getDetails());
                    deadlineLabel.setText(item.getDeadline().toString());
                }
            }
        });

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();
    }

    @FXML
    public void handleClickListView() {
        // get the TodoItem object that the user has currently selected
        TodoItem item = todoListView.getSelectionModel().getSelectedItem(); // no casting since type was specified
        //System.out.println("The selected item is " + item);
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }
}