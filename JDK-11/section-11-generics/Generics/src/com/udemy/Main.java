package com.udemy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // example without generics -> breaks compiler type checking
        ArrayList items = new ArrayList();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add("bob"); // valid without type checking -> harder to catch unexpected results
        items.add(4);
        items.add(5); // autoboxing behind the scenes

        ArrayList<Integer> moreItems = new ArrayList<>();
        printDouble(moreItems);
    }

    // without a type specified, we have to cast the object to a type to perform operations on it
    // with type specified, we can skip that step
    private static void printDouble(ArrayList<Integer> n) {
        for (Integer i : n) {
            // int can be used rather than Integer
            System.out.println(i * 2);
        }
    }
}
