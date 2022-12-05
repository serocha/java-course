package com.udemy;

import java.util.ArrayList;

public class GroceryList {

    private final ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
        System.out.println("Changes saved!");
    }

    public void printGroceryList() {
        System.out.println("Grocery list contains " + groceryList.size() + " items:");
        for (int i=0; i<groceryList.size(); i++) {
            System.out.println("\t\u2022 " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem(int index, String newItem) {
        groceryList.set(index, newItem);
        System.out.println("Changes saved!");
    }

    public void removeGroceryItem(int index) {
        if (index > -1 && index < groceryList.size()) {
            System.out.println("Deleting " + groceryList.get(index) + " at index " + index + ".");
            groceryList.remove(index);
            System.out.println("Changes saved!");
        } else {
            System.out.println("Whoops! There's no item at that index!");
        }
    }

    public String findItem(String searchItem) {
        if (groceryList.contains(searchItem)) {
            return groceryList.get(groceryList.indexOf(searchItem));
        }
        return null;
    }

    public int findItemIndex(String searchItem) {
        if (groceryList.contains(searchItem)) {
            return groceryList.indexOf(searchItem);
        }
        return -1;
    }

    public int getLength() {
        return groceryList.size();
    }
}
