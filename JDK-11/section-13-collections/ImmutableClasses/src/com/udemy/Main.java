package com.udemy;

import java.util.*;
/*
 *  A mini reproduction of the Colossal Cave text adventure game used as a demo to showcase maps
 *  NOTE: This is a continuation. Some code was refactored to better protect the location class instances
 *  NOTE: I've wrapped the challenge into this one: find out what's wrong with Location's constructor
 *        such that it can compile but crash at runtime
 *  ADDENDUM: I think the code I've already written prevents the issue. I believe the issue is that
 *            the way that the instructor wrote the code, a null HashMap() could be passed in to the
 *            Location constructor which would cause a crash.
 */
public class Main {

    public static final HashMap<String, String> vocab = new HashMap<>() {
        {
            put("QUIT", "Q");
            put("EXIT", "Q");
            put("NORTH", "N");
            put("WEST", "W");
            put("SOUTH", "S");
            put("EAST", "E");
        }
    };

    private static Map<Integer, Location> locations = new HashMap<>();
    public static void main(String[] args) {
        // I chose to enter the HashMaps differently from the course
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java.", null));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building.",
                new HashMap<>() {{
                    put("N", 5);
                    put("W", 2);
                    put("S", 4);
                    put("E", 3);
                }}));
        locations.put(2, new Location(2, "You are at the top of a hill.",
                new HashMap<>() {{
                    put("N", 5);
                    put("S", 4);
                    put("E", 1);
                }}));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring.",
                new HashMap<>() {{
                    put("W", 1);
                }}));
        locations.put(4, new Location(4, "You are in a valley beside a stream.",
                new HashMap<>() {{
                    put("N", 1);
                    put("W", 2);
                }}));
        locations.put(5, new Location(5, "You are in the forest.",
                new HashMap<>() {{
                    put("W", 2);
                    put("S", 1);
                }}));

        runGame();
    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            // locations.get(1).getExits().remove("N"); accesses a copy, original is safe, no other access
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            int counter = 0;
            for (String exit: exits.keySet()) {
                if (counter == exits.size()-1) {
                    System.out.print(exit);
                } else {
                    System.out.print(exit + ", ");
                }
                counter++;
            }
            System.out.println();

            String input = scanner.nextLine();
            String direction = parseDirection(vocab, input);

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }
    }

    public static String parseDirection(HashMap<String, String> vocab, String userInput) {
        for (String string : userInput.toUpperCase().split("( +)|([.,?!])")) {
            if ("QNWSE".contains(string)) {
                return string;
            } else if (vocab.containsKey(string)) {
                return vocab.get(string);
            }
        }
        return "";
    }
}
