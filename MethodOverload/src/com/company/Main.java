package com.company;

public class Main {

    public static void main(String[] args) {
        int newScore = calculateScore("Amrullah", 500);
        System.out.printf("New Score is %1$s\n", newScore);
        calculateScore(75);
        calculateScore();
        double feet = 6.0; double inches = 0.0;
        double centimeters = calcFeetAndInchesToCM(feet, inches);
        System.out.printf("%1$s feet, %2$s inches = %3$s centimeters\n", feet, inches, centimeters);
        inches = 1000.0;
        centimeters = calcFeetAndInchesToCM(inches);
        System.out.printf("%1$s inches = %2$s centimeters\n", inches, centimeters);
    }
    public static int calculateScore(String playerName, int score) {
        System.out.printf("Player %1$s scored %2$s points\n", playerName, score);
        return score * 1000;
    }
    public static int calculateScore(int score) {
        System.out.printf("Unnamed Player scored %1$s points\n", score);
        return score * 1000;
    }
    public static int calculateScore() {
        System.out.println("No player name, no player score");
        return 0;
    }

    public static double calcFeetAndInchesToCM(double feet, double inches) {
        if ( !(isGreaterThanZero(feet) && isInchesValid(inches)) ) {
            return -1.0;
        }
        double totalInches = (feet * 12.0) + inches;
        return 2.54 * totalInches;
    }

    public static double calcFeetAndInchesToCM(double inches) {
        if ( !isGreaterThanZero(inches) ) {
            return -1.0;
        }
        double feet = (double) (int) inches / 12;
        double remainingInches = inches % 12;
        return calcFeetAndInchesToCM(feet, remainingInches);
    }

    private static boolean isInchesValid(double inches) {
        return inches >= 0.0 && inches <= 12.0;
    }

    private static boolean isGreaterThanZero(double feet) {
        return feet >= 0.0;
    }
}
