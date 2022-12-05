package com.udemy;

import java.util.Scanner;

/*      A little grocery list manager with user input.
 *      NOTE: extra validation could be done with list item names
 *      right now it doesn't check for case, so banana, Banana, and baNana are all seen as separate entities
 *
 *      ALSO: should change the search by index
 *      The list could be numbered instead of bullets, and the user could just input the item number instead
 *      Or just drop index searching and have everything automated by name
 */

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstructions();

        while(!quit) {
            System.out.println();
            System.out.print("Please enter a command: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                choice = -1;
            }
            switch(choice) {
                case 0 -> printInstructions();
                case 1 -> printList();
                case 2 -> addItem();
                case 3 -> modifyItem();
                case 4 -> removeItem();
                case 5 -> findItem();
                case 6 -> {
                    System.out.println("Exiting the application...");
                    quit = true;
                }
                default -> {
                    System.out.println("I didn't recognize that option. Please try again.");
                    scanner.nextLine();
                }
            }
        }
    }

    private static void printInstructions() {
        System.out.println("""
                Welcome to your grocery list manager!
                Please choose from the following:
                    0 -> See these instructions again.
                    1 -> Print the current list of grocery items.
                    2 -> Add an item to the list.
                    3 -> Modify an item in the list.
                    4 -> Remove and item from the list.
                    5 -> Search for an item in the list.
                    6 -> Exit.""");
    }

    private static void addItem() {
        System.out.print("What would you like to add to the list? ");
        groceryList.addGroceryItem(scanner.nextLine());
        System.out.println("Item successfully added!");
    }

    private static void modifyItem() {
        System.out.print("Please enter the name or index of the item you want to modify: ");
        if (scanner.hasNextInt()) {
            int index = scanner.nextInt();
            scanner.nextLine();
            if (index > groceryList.getLength()-1) {
                System.out.println("Sorry, there's no item at position " + index + ". Sending you back to the main menu.");
                return;
            }
            System.out.print("What would you like to replace the item with? ");
            groceryList.modifyGroceryItem(index, scanner.nextLine());
        } else if (scanner.hasNextLine()) {
            String item = scanner.nextLine();
            System.out.print("What would you like to replace the item with? ");
            groceryList.modifyGroceryItem(groceryList.findItemIndex(item), scanner.nextLine());
        } else {
            System.out.println("Uh oh, something went wrong! Sending you back to the main menu.");
        }
    }

    private static void removeItem() {
        System.out.print("Please enter the name or index of the item you want to remove: ");
        if (scanner.hasNextInt()) {
            groceryList.removeGroceryItem(scanner.nextInt());
            scanner.nextLine();
        } else if (scanner.hasNextLine()) {
            groceryList.removeGroceryItem(groceryList.findItemIndex(scanner.nextLine()));
        }
    }

    private static void findItem() {
        System.out.print("What item are you checking for? ");
        String item = scanner.nextLine();
        if (groceryList.findItem(item) != null) {
            System.out.println(groceryList.findItem(item) + " is on the list!");
        } else {
            System.out.println(item + " is not currently on the list!");
        }
    }

    private static void printList() {
        groceryList.printGroceryList();
    }
}
