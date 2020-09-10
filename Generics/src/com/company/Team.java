package com.company;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>>{  // without "extends Player" we would be able do to Team<String> = new Team<>()
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.printf("Player %1$s is already in the team\n", player);
            return false;
        } else {
            members.add(player);
            System.out.printf("Player %1$s added to team %2$s\n", player, this);
            return true;
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int numPlayers() {
        return this.members.size();
    }
    //not supplying <T> along with Team will allow heterogenous teams to be accepted in this method
    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;

        if (ourScore > theirScore) {
            won++;
            message = " beat ";
        } else if (ourScore == theirScore) {
            tied++;
            message = " drew with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if (opponent != null) {
            System.out.printf("%1$s %2$s %3$s\n", this, message, opponent);
            opponent.matchResult(null, theirScore, ourScore);
        }
    }
    public int ranking() {
        return (won * 2) + tied;
    }

    @Override
    public int compareTo(Team<T> otherTeam) {
        if (this.ranking() > otherTeam.ranking()) {
            return -1;
        } else if (this.ranking() < otherTeam.ranking()) {
            return 1;
        }
        return 0;
    }
}
