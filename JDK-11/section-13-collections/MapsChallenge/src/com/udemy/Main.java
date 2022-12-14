package com.udemy;

import java.util.*;

/*
 *  A mini reproduction of the Colossal Cave text adventure game
 *  used as a demo to showcase maps
 */
public class Main {

    public static HashMap<String, String> vocab = new HashMap<>() {
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
        /*  (My shorthand of instructions, all changes are in the while loop at the bottom)
         *  Change the program to allow players to type full words or phrases, then move to correct location
         *  Player should be able to type commands like "Go West", "run South", or just "East"
         *  Invalid entries should have the player remain in the same location and print that you can't go there
         *  Single letter commands (N, W, S, E, Q) should still be available
         */

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java."));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building."));
        locations.put(2, new Location(2, "You are at the top of a hill."));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring."));
        locations.put(4, new Location(4, "You are in a valley beside a stream."));
        locations.put(5, new Location(5, "You are in the forest."));

        // this is ugly but I felt it easier than calling .addExit() for each
        createExit(1, new HashMap<>() {{
            put("N", 5);
            put("W", 2);
            put("S", 4);
            put("E", 3);}});
        createExit(2, new HashMap<>() {{
            put("N", 5);
            put("S", 4);
            put("E", 1);}});
        createExit(3, new HashMap<>() {{
                put("W", 1);}});
        createExit(4, new HashMap<>() {{
            put("N", 1);
            put("W", 2);}});
        createExit(5, new HashMap<>() {{
            put("W", 2);
            put("S", 1);}});

        runGame();
    }

    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit: exits.keySet()) {
                System.out.print(exit + ", ");
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

    public static void createExit(int location, HashMap<String, Integer> exits) {
        // Quickly slapped together because I didn't want to add entries one by one using .addExit()
        // not sure if it saved any time, but I learned a new way to instantiate a Map
        String direction = "";
        for (int i=0; i<4; i++) {

            switch(i) {
                case 0 -> direction = "N";
                case 1 -> direction = "W";
                case 2 -> direction = "S";
                case 3 -> direction = "E";
            }
            if (exits.containsKey(direction)) {
                locations.get(location).addExit(direction, exits.get(direction));
            }
        }
    }
}
