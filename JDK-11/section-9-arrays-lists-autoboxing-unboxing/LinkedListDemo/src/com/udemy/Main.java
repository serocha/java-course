package com.udemy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit,"Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Canberra");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Darwin");

        printList(placesToVisit);

        addInOrder(placesToVisit, "Alice Springs"); // LinkedList changes link pointer behind the scenes
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);

        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator(); // provides quick and easy functionality to iterate

        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("======================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator(); // added functionality for lists
        while(stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity); // ListIterator doesn't auto point to first entry
            if (comparison == 0) {
                // compareTo() returns 0 if strings match
                System.out.println(newCity + " is already a destination");
                return false;
            } else if (comparison > 0) {
                // compareTo() returns positive if newCity precedes the comparison string
                // however, we've already called .next(), so we have to go back
                stringListIterator.previous(); // newCity needs to go before the entry
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                // keep going
            }
        }
        // newCity shouldn't precede any entries, so add at the end
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        // have to track direction, because ListIterator "hovers" between data points
        // this is part of an algorithm to prevent situations with unwanted looping
        // if you just call .reverse(), you'll hit the previous destination twice
        boolean goingForward = true;
        ListIterator<String> listIterator= cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        } else {
            System.out.println("Now visiting" + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action) {
                case 0 ->  {
                    System.out.println("Vacation over");
                    quit = true;
                }
                case 1 -> {
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                            goingForward = true;
                        }
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("No new cities to visit.");
                        goingForward = false;
                    }
                }
                case 2 -> {
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous(); // correctly position within list
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("Back at the starting city.");
                        goingForward = true;
                    }
                }
                case 3 -> printMenu();
            }
        }
    }

    private static void printMenu() {
        System.out.println("""
                Available Actions
                0 --> End vacation
                1 --> Go to next destination
                2 --> Go back  to previous destination
                3 --> Show this menu again""");
    }
}
