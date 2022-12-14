package com.udemy;
/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private Map<Integer, Location> locations = new HashMap<Integer, Location>();
    private Map<String, String> vocabulary = new HashMap<>(){
        {
            put("NORTH", "N");
            put("WEST", "W");
            put("SOUTH", "S");
            put("EAST", "E");
            put("QUIT", "Q");
        }
    };

    public static void main(String[] args) {
        Main main = new Main();
        main.command();
    }
    public Main() {

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
    }

    public void command() {
        // write code here
        Scanner scanner = new Scanner(System.in);
        int loc = 1;

        while(true) {
            System.out.println(locations.get(loc).getDescription());
            System.out.println();
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String string : exits.keySet()) {
                System.out.print(string + ", ");
            }
            System.out.println();
            String stringInput = scanner.nextLine().toUpperCase();
            for (String word : stringInput.split("\\s+")){
                if (vocabulary.containsKey(word)) {
                    stringInput = vocabulary.get(word);
                    break;
                } else if ("QNWSE".contains(word)) {
                    stringInput = word;
                    break;
                }
            }
            if (exits.containsKey(stringInput)) {
                loc = locations.get(loc).getExits().get(stringInput);
            } else {
                System.out.println("You cannot go in that direction");
                System.out.println();
            }
        }
    }
}