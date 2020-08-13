package com.company;

public class Main {

    public static void main(String[] args) {
	    boolean gameOver = true;
	    int score = 800;
	    int levelCompleted = 5;
	    int bonus = 100;

		int highScore = calculateScore(gameOver, score, levelCompleted, bonus);
		System.out.println("Your final Score was " + highScore);

		System.out.println("Your final Score was " +
				calculateScore(true, 10000, 8, 200));
    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {
		int finalScore = -1;
		if (gameOver) {
			 finalScore = score + (levelCompleted * bonus);
		}

		if (score < 5000 && score > 1000) {
			System.out.println("Your score was less than 5000 but greater than 1000");
		} else if (score < 1000) {
			System.out.println("Your score was less than 1000");
		}
		else {
			System.out.println("Got here!");
		}

		// can't access finalScore as it was declared within the if block
		return finalScore;
	}
}
