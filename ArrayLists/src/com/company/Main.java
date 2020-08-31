package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice;
        printInstructions();
        while (!quit) {
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchItem();
                    break;
                case 6:
                    processArrayList();
                case 7:
                    quit = true;
                    break;
                default:
                    printInstructions();
            }
        }
    }

    private static void processArrayList() {
        ArrayList<String> newArray = new ArrayList<>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> oneMoreArray = new ArrayList<>(groceryList.getGroceryList());

        String[] myArray = new String[groceryList.getGroceryList().size()];
        myArray = groceryList.getGroceryList().toArray(myArray);
    }

    private static void searchItem() {
        System.out.print("Please enter the item to search for: ");
        String searchTerm = scanner.nextLine();

        if (groceryList.exists(searchTerm)) {
            System.out.printf("Found %1$s in the grocery list\n", searchTerm);
        } else {
            System.out.printf("%1$s is not in the grocery list\n", searchTerm);
        }
    }

    private static void removeItem() {
        System.out.print("Please enter the item to remove: ");
        String item = scanner.nextLine();

        groceryList.removeGroceryItem(item);
        System.out.println("Item has been removed");
    }

    private static void modifyItem() {
        System.out.print("Please enter the item to replace: ");
        String oldItem = scanner.nextLine();

        System.out.print("Enter replacement item: ");
        String newItem = scanner.nextLine();

        groceryList.modifyGroceryItem(oldItem, newItem);
    }

    private static void addItem() {
        System.out.println("Please enter the grocery item to add:");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    private static void printInstructions() {
        System.out.println("\nPress:");
        System.out.println("\t0 - to print choice options");
        System.out.println("\t1 - to print list of grocery items");
        System.out.println("\t2 - to add an item to the list");
        System.out.println("\t3 - to modify an item in the list");
        System.out.println("\t4 - to remove an item from the list");
        System.out.println("\t5 - to search for an item in the list");
        System.out.println("\t6 - to quit the application");
    }


}
