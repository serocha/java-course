package com.udemy;
import com.abc.first.*; // this form is less used as IDEs have become more prevalent
// import com.abc.first.Item

public class Main {

    public static void main(String[] args) {

        // Item firstItem = new Item("Burger");
        // com.abc.first.Item firstItem = new com.abc.first.Item("Burger");
        Item firstItem = new Item("Burger");
        System.out.println(firstItem.toString());
    }
}
