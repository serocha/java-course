package com.udemy;

import com.example.game.*; // can also do individual imports

public class Main {

    public static void main(String[] args) {

        System.out.println("Check it out, your first package.");
        Player player = new Player("Hero", 100, 5);
        System.out.println(player.getName() + " has " + player.getHitPoints() + " hit points");
        System.out.println(player);
        ISaveable monster = new Monster("Werewolf", 50, 10);
        System.out.println(monster);
    }
}
