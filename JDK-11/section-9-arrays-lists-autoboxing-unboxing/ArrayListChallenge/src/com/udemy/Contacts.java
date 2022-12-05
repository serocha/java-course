package com.udemy;

import java.util.ArrayList;
import java.util.Scanner;

public class Contacts {

    ArrayList<Contact> contacts;
    Scanner scanner = new Scanner(System.in);

    public Contacts() {
        this.contacts = new ArrayList<>();
    }

    protected void run() {
        boolean isRunning = true;
        int choice;
        printInstructions();

        while(isRunning) {
            System.out.println();
            System.out.print("Please enter a command: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                choice = -1;
            }
            switch(choice) {
                case 1 -> printInstructions();
                case 2 -> printContacts();
                case 3 -> addContact();
                case 4 -> deleteContact();
                case 5 -> editContact();
                case 6 -> searchContact();
                case 7 -> {
                    System.out.println("Exiting contacts...");
                    isRunning = false;
                }
                default -> {
                    System.out.println("I didn't recognize that option. Please try again.");
                    scanner.nextLine();
                }
            }
        }
    }

    private void printInstructions() {
        System.out.println("""
                Welcome to your contacts!
                Please choose from the following options:
                    1 -> Display these options again
                    2 -> Show all contacts
                    3 -> Add new contact
                    4 -> Delete contact
                    5 -> Edit existing contact
                    6 -> Search for contact
                    7 -> Close contacts""");
    }

    private void printContacts() {
        for (Contact contact : contacts) {
            System.out.printf("%-20s%s%n", contact.getName(), contact.getPhoneNumber());
        }
    }

    private void addContact() {
        String name = validateName("Please enter a name for the contact: ");
        String phoneNumber = validateNumber("Please enter a phone number for " + name + ": ");

        contacts.add(new Contact(name, phoneNumber));
        System.out.println(name + " has been successfully added to contacts.");
    }

    private void deleteContact() {
        System.out.print("Which contact would you like to delete? ");
        boolean hasBeenDeleted = false;
        String deleteName = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equals(deleteName)) {
                contacts.remove(contact);
                System.out.println(deleteName + " was successfully deleted.");
                hasBeenDeleted = true;
                break;
            }
        }
        if (!hasBeenDeleted) {
            System.out.println("No such contact found. Returning to menu.");
        }
    }

    private void editContact() {
        System.out.print("Which contact would you like to edit? ");
        String editName = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equals(editName)) {
                System.out.print("Did you want to edit the name? [Y/N]: ");
                String confirmation = scanner.nextLine();
                if ("Yy".contains(confirmation)) {
                    contact.setName(validateName("New contact name: "));
                    System.out.println("Contact name updated.");
                }

                System.out.print("Did you want to edit the phone number? [Y/N]: ");
                confirmation = scanner.nextLine();
                if ("Yy".contains(confirmation)) {
                    contact.setPhoneNumber(validateNumber("New phone number: "));
                    System.out.println("Phone number updated.");
                }
                System.out.println("Contact successfully updated.");
                return;
            }
        }
        System.out.println("No contact " + editName + " found.");
    }

    private void searchContact() {
        System.out.print("Which contact are you looking for? ");
        String searchName = scanner.nextLine();
        for (Contact contact : contacts) {
            if (contact.getName().equals(searchName)) {
                System.out.printf("%-20s%s%n", contact.getName(), contact.getPhoneNumber());
            }
        }
    }

    private String validateNumber(String message) {
        boolean isValidNumber = false;
        System.out.print(message);
        String phoneNumber = scanner.nextLine();
        message = "Not a valid phone number. Please enter again: ";
        while (!isValidNumber) {
            if (phoneNumber.matches("\\d{10}") || phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {
                isValidNumber = true;
            } else {
                System.out.print(message);
                phoneNumber = scanner.nextLine();
            }
        }
        return phoneNumber;
    }

    private String validateName(String message) {
        // this checks to see if a name is already in contacts
        boolean isValidName = false;
        boolean isExistingName = false;
        System.out.print(message);
        String name = scanner.nextLine();
        message = "Name is already in use. Please enter a new name: ";
        while (!isValidName) {
            for (Contact contact : contacts) {
                if (name.equals(contact.getName())) {
                    isExistingName = true;
                }
            }
            if (isExistingName) {
                System.out.print(message);
                name = scanner.nextLine();
            } else {
                isValidName = true;
            }
            isExistingName = false;
        }
        return name;
    }
}
