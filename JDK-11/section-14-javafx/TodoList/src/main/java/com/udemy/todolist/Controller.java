package com.udemy.todolist;

import com.udemy.todolist.datamodel.TodoData;
import com.udemy.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {

    private List<TodoItem> todoItems;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineDay;
    @FXML
    private Label deadlineLabel;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ComboBox<String> filterOption;
    @FXML
    private FilteredList<TodoItem> filteredList;

    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantDailyItems;
    private Predicate<TodoItem> wantWeeklyItems;
    private Predicate<TodoItem> wantMonthlyItems;

    public void initialize() {
        // define context menu for right click
        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        MenuItem editMenuItem = new MenuItem("Edit Entry");
        editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                editItemDialog(item);
            }
        });

        listContextMenu.getItems().addAll(editMenuItem);
        listContextMenu.getItems().addAll(deleteMenuItem);

        // declare a listener to todoListView (JavaFX observable List)
        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            // not using lambda's because we haven't covered them yet, implement old anonymous class method override
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem(); // get the current selection
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("EEEE, ");
                    deadlineDay.setText(df.format(item.getDeadline().getDayOfWeek()));
                    df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        initPredicates(); // declare predicates
        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), wantAllItems);
        SortedList<TodoItem> sortedList = new SortedList<>(filteredList, new Comparator<TodoItem>() {
            @Override
            public int compare(TodoItem o1, TodoItem o2) {
                return o1.getDeadline().compareTo(o2.getDeadline()); // use LocalDates compare method
            };
        });

        // update from singleton ObservableList and binds the data to the controller
        //todoListView.setItems(TodoData.getInstance().getTodoItems());
        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        // CellFactory -> anonymous Callback interface (JavaFX) with 2 type params, the passed and the returned
        // anonymous class to create ListCell instances and overriding updateItem() which runs when ListCell wants
        // to paint a single cell
        todoListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                ListCell<TodoItem> cell = new ListCell<>() {
                    // update cell font colors based on expiration
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty); // keep a lot of the default appearance
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().equals(LocalDate.now())) {
                                setTextFill(Color.RED); // redraw if the event expires today
                            } else if (LocalDate.now().isAfter(item.getDeadline())) {
                                setTextFill(Color.LIGHTGRAY); // past expired
                            } else if (item.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.DARKORANGE); // near expiration
                            } else {
                                setTextFill(Color.BLACK);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(
                    (obs, wasEmpty, isNowEmpty) -> {
                        if (isNowEmpty) {
                            cell.setContextMenu(null);
                        } else {
                            cell.setContextMenu(listContextMenu);
                        }
                    });

                return cell;
            }
        });
    }

    @FXML
    public void showNewItemDialog() {
        // could refactor with editItemDialog() to reduce repeated code
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("New Event");
        dialog.setHeaderText("Create New Event");
        dialog.initOwner(mainBorderPane.getScene().getWindow()); // set owner
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));
        // load FXML for the dialog window or throw exception
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait(); // suspend until dialog is resolved
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem item = controller.processResult();

            //todoListView.setItems(TodoData.getInstance().getTodoItems());
            todoListView.getSelectionModel().select(item); // update selection to new item
        }
    }

    @FXML
    public void editItemDialog(TodoItem itemToEdit) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Edit Event");
        dialog.setHeaderText("Edit Existing Event");
        dialog.initOwner(mainBorderPane.getScene().getWindow()); // set owner
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));

        // load FXML for the dialog window or throw exception
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
        }

        DialogController controller = fxmlLoader.getController();
        controller.loadExistingEvent(itemToEdit);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            TodoItem item = controller.editResult(itemToEdit);
            todoListView.getSelectionModel().select(item); // update selection to new item
        }
    }

    @FXML
    public void menuEditItem() {
        // pass current selection to edit dialog
        editItemDialog(todoListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void menuDeleteItem() {
        // pass current selection for deletion
        deleteItem(todoListView.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void deleteItem(TodoItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete");
        alert.setHeaderText("Delete '" + item.getShortDescription() + "'?");
        alert.setContentText("This action cannot be undone.");
        alert.getDialogPane().setPadding(new Insets(10,0, 0, 10));
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            TodoData.getInstance().removeTodoItem(item);
        }
    }

    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        // this handler checks if delete is pressed while an event is focused
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        if (item != null) {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                deleteItem(item);
            }
        }
    }

    @FXML
    public void filterHandler() {
        // handle the predicates for the filtered list defined in initialize(); should refactor to use const
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (filterOption.getValue().equals("Today")) {
            filteredList.setPredicate(wantDailyItems);
        } else if (filterOption.getValue().equals("This Week")) {
            filteredList.setPredicate(wantWeeklyItems);
        } else if (filterOption.getValue().equals("This Month")) {
            filteredList.setPredicate(wantMonthlyItems);
        } else {
            clearFilterHandler();
        }
        if (filteredList.isEmpty()) {
            itemDetailsTextArea.clear();
            deadlineLabel.setText("");
        } else if (filteredList.contains(selectedItem)) {
            todoListView.getSelectionModel().select(selectedItem);
        } else {
            todoListView.getSelectionModel().selectFirst();
        }
    }

    @FXML
    public void clearFilterHandler() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        filteredList.setPredicate(wantAllItems);
        todoListView.getSelectionModel().select(selectedItem); // move to default value
    }

    @FXML
    public void exitHandler() {
        Platform.exit();
    }

    @FXML
    public void handleClickListView() {
        // get the TodoItem object that the user has currently selected
        TodoItem item = todoListView.getSelectionModel().getSelectedItem(); // no casting since type was specified
        //System.out.println("The selected item is " + item);
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
    }

    private void initPredicates(){
        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return true;
            }
        };

        wantDailyItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return item.getDeadline().isEqual(LocalDate.now());
            }
        };

        wantWeeklyItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return item.getDeadline().isBefore(LocalDate.now().plusDays(6));
            }
        };

        wantMonthlyItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return item.getDeadline().isBefore(LocalDate.now().plusDays(30));
            }
        };
    }
}