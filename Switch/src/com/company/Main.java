package com.company;

public class Main {

    public static void main(String[] args) {
	    int value = 3;
	    if (value == 1) {
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Value was neither 1 nor 2");
        }

	    // switch-case equivalent of above:
        switch (value) {
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:
                System.out.println("Value was 3 or 4 or 5");
                System.out.println("Actually it was " + value);
                break;
            default:
                System.out.println("Value was neither 1 nor 2");
        }

	    char character = 'D';
	    switch (character) {
            case 'A': case 'B': case 'C': case 'D': case 'E':
                System.out.println("Found " + character);
                break;
            default:
                System.out.println("Not Found");
        }
    }
}
