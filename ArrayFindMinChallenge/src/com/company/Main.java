package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the number of Integers: \r");
        int numberOfIntegers = scanner.nextInt();

        int[] arrayOfInts = readIntegers(numberOfIntegers);
        System.out.printf("\nThe numbers entered are: %1$s", Arrays.toString(arrayOfInts));

        int minValue = findMin(arrayOfInts);

        System.out.printf("\nThe minimum of all these numbers is: %1$s\n", minValue);
    }

    private static int findMin(int[] arrayOfInts) {
        int minimumSoFar = Integer.MAX_VALUE;
        for (int number : arrayOfInts) {
            if (number < minimumSoFar) {
                minimumSoFar = number;
            }
        }
        return minimumSoFar;
    }

    private static int[] readIntegers(int numberOfIntegers) {
        int[] arrayOfInts = new int[numberOfIntegers];
        for (int i=0; i < numberOfIntegers; i++) {
            System.out.printf("Enter number #%1$s \r", i+1);
            arrayOfInts[i] = scanner.nextInt();
        }
        return arrayOfInts;
    }
}
