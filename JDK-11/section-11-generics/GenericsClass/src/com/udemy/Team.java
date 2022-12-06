package com.udemy;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
// add a diamond with <T> to tell it to expect a type T
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;
    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            // no longer requires a cast
            System.out.println(player.getName() + " is already on the team.");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " added to the team " + this.name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " tied with ";
        } else {
            message = " lost to ";
            lost++;
        }
        played++;
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName() + ", " + ourScore + "-" + theirScore);
            // call function again to update other team's score, null to prevent endless recursion
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking() {
        return ((won * 4) + (tied * 2) + lost)/played; // arbitrary ranking
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()) {
            return -1; // current team ranks higher than the passed param
        } else if (this.ranking() < team.ranking()) {
            return 1;
        }
        return 0;
    }
}
