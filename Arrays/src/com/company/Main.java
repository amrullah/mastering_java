package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	    int[] myIntArray = new int[10];
	    myIntArray[5] = 50;

	    double[] myDoubleArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(myIntArray[5]);
        System.out.println(Arrays.stream(myDoubleArray).count());

        String[] myStringArray = new String[10];

        for (int i=1; i <= myStringArray.length; i++) {
            myStringArray[i-1] = Integer.toString(i*10);
        }

        for (String s : myStringArray) {
            System.out.print(s + " ");
        }
        System.out.println("");

        int[] myIntegers = getIntegers(5);

        double average = getAverage(myIntegers);
        System.out.printf("The average is %1$s\n", average);
    }

    private static double getAverage(int[] numbers) {
        int sum = 0;

        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / (double) numbers.length;
    }

    private static int[] getIntegers(int numberOfElements) {
        System.out.printf("Enter %1$s integer values\n\r", numberOfElements);
        int[] values = new int[numberOfElements];

        for (int i=0; i < numberOfElements; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }
}
