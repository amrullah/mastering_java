package com.company;

public class Main {

    public static void main(String[] args) {
        calculateAndDisplayPosition("Amrullah", 1500);
        calculateAndDisplayPosition("Zaid", 900);
        calculateAndDisplayPosition("Martin", 400);
        calculateAndDisplayPosition("Raju", 50);
    }
    public static void calculateAndDisplayPosition(String playerName, int score) {
        int position = calculateHighScorePosition(score);
        displayHighScorePosition(playerName, position);
    }
    public static void displayHighScorePosition(String playerName, int position) {
        System.out.printf("Player %1$s has position %2$s in the high score table %n", playerName, position);
    }
    public static int calculateHighScorePosition(int score) {
        int position = 4;
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        }
        return position;
    }
}
