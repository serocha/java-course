package com.udemy;

import java.util.ArrayList;

public class Team<T extends Sport> implements Comparable<Team<T>> {

    private final String name;
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
    private int played = 0;
    private int totalPointsScored = 0;
    private int totalPointsAllowed = 0;
    private final ArrayList<String> members = new ArrayList<>(); // not implemented

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getMembers() {
        // no members implemented
        return members;
    }

    public void matchResult(Team<?> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            wins++;
            message = " won against ";
        } else if (ourScore == theirScore) {
            ties++;
            message =  " tied against ";
        } else {
            losses++;
            message = " lost against ";
        }
        totalPointsScored += ourScore;
        totalPointsAllowed += theirScore;
        played++;
        if (opponent != null) {
            System.out.println(this.getName() + message + opponent.getName() + ", " + ourScore + "-" + theirScore);
            // call function again to update other team's score, null to prevent endless recursion
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int getRanking() {
        // all of this is just to increase the variability of ranking somewhat
        // it was too common for teams to have equal scores when just calculating off of wins/losses
        double ratio = (double) (totalPointsScored/totalPointsAllowed);

        return (int) (5 * wins) + (int) (2 * wins * ratio) + (int) (totalPointsScored * 0.01) +
                (2 * ties) - losses - (int) (totalPointsAllowed * 0.02);
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.getRanking() > team.getRanking()) {
            return -1; // current team ranks higher than the passed param
        } else if (this.getRanking() < team.getRanking()) {
            return 1;
        }
        return 0;
    }
}
