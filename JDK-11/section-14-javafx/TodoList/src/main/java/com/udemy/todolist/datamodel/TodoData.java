package com.udemy.todolist.datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// simple data handling singleton that reads and writes to a plain text file
// wouldn't use in production, but works for this purpose
public class TodoData {

    private static TodoData instance = new TodoData();
    private static String filename = "TodoListItems.txt";
    private ObservableList<TodoItem> todoItems;
    private DateTimeFormatter df;

    public static TodoData getInstance() {
        return instance;
    }

    private TodoData() {
        df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public void addTodoItem(TodoItem item) {
        todoItems.add(item);
    }

    public void addTodoItem(TodoItem item, int index) {
        todoItems.add(index, item);
    }

    public void removeTodoItem(TodoItem item) {
        todoItems.remove(item);
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void loadTodoItems() throws IOException {
        todoItems = FXCollections.observableArrayList(); // JavaFX ObservableLists raise optimized events
        Path path = Paths.get(filename);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String input;
            while ((input = br.readLine()) != null) {
                String[] itemPieces = input.split("\t"); // delimiter, would use XML or database in real world
                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                LocalDate date = LocalDate.parse(itemPieces[2], df);

                todoItems.add(new TodoItem(shortDescription, details, date));
            }
        }
    }

    public void storeTodoItems() throws IOException {
        Path path = Paths.get(filename);

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (TodoItem item : todoItems) {
                // String.format is for the purpose of this exercise, should use XML or database
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(df)));
                bw.newLine();
            }
        }
    }
}
