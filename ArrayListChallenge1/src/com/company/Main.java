package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean quit = false;
        int choice;

        while (!quit) {
            printOptions();
            System.out.print("\nEnter your choice: ");
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please add a valid number");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();

            switch (choice) {
                case 1:
                    MobilePhone.showContacts();
                    break;
                case 2:
                    MobilePhone.addContact();
                    break;
                case 3:
                    MobilePhone.modifyContact();
                    break;
                case 4:
                    MobilePhone.removeContact();
                    break;
                case 5:
                    MobilePhone.searchContact();
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    printOptions();
            }
        }
    }

    private static void printOptions() {
        System.out.println("\nPress:");
        System.out.println("\t0 - to print choice options");
        System.out.println("\t1 - to show contacts");
        System.out.println("\t2 - to add contact");
        System.out.println("\t3 - to modify a contact");
        System.out.println("\t4 - to remove a contact");
        System.out.println("\t5 - to search for a contact");
        System.out.println("\t6 - to quit the application");
    }
}
