package com.udemy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 *  A mini reproduction of the Colossal Cave text adventure game
 *  used as a demo to showcase maps
 */
public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java."));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building."));
        locations.put(2, new Location(2, "You are at the top of a hill."));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring."));
        locations.put(4, new Location(4, "You are in a valley beside a stream."));
        locations.put(5, new Location(5, "You are in the forest."));

        createExit(1, new HashMap<>() {
            {
                put("N", 5);
                put("W", 2);
                put("S", 4);
                put("E", 3);
            }
        });

        createExit(2, new HashMap<>() {
            {
                put("N", 5);
                put("S", 4);
                put("E", 1);
            }
        });

        createExit(3, new HashMap<>() {
            {
                put("W", 1);
            }
        });

        createExit(4, new HashMap<>() {
            {
                put("N", 1);
                put("W", 2);
            }
        });

        createExit(5, new HashMap<>() {
            {
                put("W", 2);
                put("S", 1);
            }
        });

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

            String direction = scanner.nextLine().toUpperCase();
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction.");
            }
        }
    }

    public static void createExit(int location, HashMap<String, Integer> exits) {
        // Quickly slapped together because I didn't want to add entries one by one using .addExit()
        // not sure if it saved any time, but I learned a new way to instantiate a Map
        String direction = "";
        for (int i=0; i<4; i++) {

            switch(i) {
                case 0 -> direction = "N";
                case 1 -> direction = "E";
                case 2 -> direction = "S";
                case 3 -> direction = "W";
            }
            if (exits.containsKey(direction)) {
                locations.get(location).addExit(direction, exits.get(direction));
            }
        }
    }
}
