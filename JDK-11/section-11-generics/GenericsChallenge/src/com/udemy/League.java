package com.udemy;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team<? extends Sport>> {
    private final String name;
    private final ArrayList<T> teams = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<T> getTeams() {
        return teams;
    }

    public void addTeam(T team) {
        if (team == null) {
            // revisit null, likely a pointless inclusion
            System.out.println("Invalid team.");
        } else if (teams.contains(team)) {
            System.out.println(team.getName() + " is already in the " + this.getName() + " league");
        } else {
            teams.add(team);
            System.out.println(team.getName() + " was added to the " + this.getName() + " league");
        }
    }

    public void sortByRanking() {
        Collections.sort(teams);
        System.out.println(this.getName() + " League Rankings");
        for (int i=0; i<teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getName() + ": " + teams.get(i).getRanking() + " pts");
        }
    }
}
