package com.company;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        LinkedList<String> cities = new LinkedList<>();

        addInOrder(cities, "Sydney");
        addInOrder(cities, "Mumbai");
        addInOrder(cities, "Dubai");
        addInOrder(cities, "Kuala Lumpur");
        addInOrder(cities, "Johannesburg");
        addInOrder(cities, "Marakkesh");
        addInOrder(cities, "New York");
        addInOrder(cities, "Dubai");


        printList(cities);

        visit(cities);

    }

    private static void printList(LinkedList<String> list) {
        Iterator<String> i = list.iterator();
        System.out.println("------------------------");
        while (i.hasNext()) {
            System.out.printf("Now visiting: %1$s\n", i.next());
        }
        System.out.println("------------------------");
    }

    private static boolean addInOrder(LinkedList<String> list, String newCity) {
        ListIterator<String> i = list.listIterator();

        while (i.hasNext()) {
            int comparison = i.next().compareTo(newCity);

            if (comparison == 0) {
                // equal
                System.out.printf("%1$s already exists in cities", newCity);
                return false;
            } else if (comparison > 0) {
                // newCity should appear before this one
                i.previous();
                i.add(newCity);
                return true;
            } else {
                // move to next city
            }

        }
        i.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> iterator = cities.listIterator();

        if (cities.isEmpty()) {
            System.out.println("No cities in the itinerary");
            return;
        } else {
            System.out.println("Now visiting " + iterator.next());
            printMenu();
        }
        while (!quit) {
            int action;
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException e) {
                action = -1;
            }
            scanner.nextLine();  // discard new line character


            switch (action) {
                case 0:
                    System.out.println("Vacation over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        goingForward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.printf("Now visiting %1$s\n", iterator.next());
                    } else {
                        goingForward = false;
                        System.out.println("Reached the end of the itinerary");
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        goingForward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.printf("Now visiting %1$s\n", iterator.previous());
                    } else {
                        goingForward = true;
                        System.out.println("Reached the start of the itinerary");
                    }
                    break;
                default:
                    printMenu();
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nAvailable actions: Press");
        System.out.println("0 - to quit");
        System.out.println("1 - go to next city");
        System.out.println("2 - go to previous city");
        System.out.println("Any key - to print the menu");
    }
}
