package com.company;

import java.time.Year;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter your birth year: ");
        boolean hasNextInt = scanner.hasNextInt();

        if (!hasNextInt) {
            System.out.println("Unable to parse birth year");
            return;
        }
        int yearOfBirth = scanner.nextInt();
        int currentYear = Year.now().getValue();
        int age = currentYear - yearOfBirth;

        scanner.nextLine();  // added to discard the `Enter` key-press done during entering the birth year.

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        if (age > 0 && age <= 120) {
            System.out.printf("Your name is %1$s\n", name);
            System.out.printf("Your age is %1$s", age);
        } else {
            System.out.println("Invalid birth year");
        }
        scanner.close();
    }
}
