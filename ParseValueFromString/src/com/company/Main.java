package com.company;

public class Main {

    public static void main(String[] args) {
	    String numberAsString = "2018"; // will raise NumberFormatException if the string is not numeric

	    int number = Integer.parseInt(numberAsString);

        System.out.println(number);

        numberAsString += 1;
        number += 1;
        System.out.println(numberAsString);
        System.out.println(number);

        double doubleNumber = Double.parseDouble(numberAsString);
        System.out.println(doubleNumber);
    }
}
