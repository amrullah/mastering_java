package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i = 1; int sum = 0;
        while (i <= 10) {
            System.out.printf("Enter number #%1$s:", i);
            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number");
                scanner.nextLine();
                continue;
            }
            int number = scanner.nextInt();
            sum += number;
            i++;
        }
        System.out.printf("Sum of 10 numbers is: %1$s", sum);
        scanner.close();
    }
}
