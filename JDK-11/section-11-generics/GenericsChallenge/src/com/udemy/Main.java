package com.udemy;

import java.util.ArrayList;

/*
*   Quick little program that creates a sports league with teams
*   Leagues only accept teams that share the same sport, and teams must have a defined sport (generic types)
*   A method does a basic simulation of the season
*   The league calculates the league rank based on a Collections.sort() of an overridden compareTo() method from Team
*/
public class Main {

    public static void main(String[] args) {

        Team<Baseball> isotopes = new Team<>("ABQ Isotopes");
        Team<Soccer> united = new Team<>("NM United");

        ArrayList<String> teamNames = new ArrayList<>();
        teamNames.add("New Mexico Lobos");
        teamNames.add("New Mexico State Aggies");
        teamNames.add("Colorado Buffaloes");
        teamNames.add("Denver Pioneers");
        teamNames.add("Arizona Wildcats");
        teamNames.add("Arizona State Sun Devils");
        teamNames.add("Utah Utes");
        teamNames.add("BYU Cougars");
        teamNames.add("Nevada Wolf Pack");
        teamNames.add("UNLV Rebels");
        teamNames.add("West Texas A&M Buffaloes");
        teamNames.add("Midwestern State Mustangs");


        League<Team<Football>> southwestFootball = new League<>("Southwest Football");
        for (String string : teamNames) {
            southwestFootball.addTeam(new Team<>(string)); // implicit type from League<Team<Football>>
        }
        //southwestFootball.addTeam(isotopes); // must be like types, won't compile
        System.out.println();
        simulateGames(southwestFootball);
        System.out.println();
        southwestFootball.sortByRanking();
    }

    private static void simulateGames(League<Team<Football>> league) {
        System.out.println("Simulating season...");
        ArrayList<Team<Football>> members = league.getTeams(); // just here for easier reading
        int position = 0;
        for (Team<?> team : members) {
            for (int i = position; i < members.size(); i ++) {
                if (!team.getName().equals(members.get(i).getName())) {
                    int ourScore = (int) (Math.random() * 56);
                    int theirScore = (int) (Math.random() * 56);
                    team.matchResult(members.get(i), ourScore, theirScore);
                }
            }
            position++;
        }
    }
}
