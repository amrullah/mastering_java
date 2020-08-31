package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Contact> contacts = new ArrayList<>();

    public static void addContact() {
        System.out.println("** Add new Contact **");
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the number: ");
        String number = scanner.nextLine();

        contacts.add(new Contact(name, number));
        System.out.println("** Contact Added **");
    }
    public static void modifyContact() {
        System.out.println("** Modify the Contact **");
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        int position = getPosition(name);
        if (position >= 0) {
            System.out.print("Enter the new number: ");
            String number = scanner.nextLine();
            contacts.get(position).setNumber(number);
            System.out.println("** Contact Updated **");
        } else {
            System.out.printf("** No Contact with name %1$s found **\n", name);
        }

    }

    private static int getPosition(String name) {
        int position = -1;
        int index = 0;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                position = index;
                break;
            }
            index += 1;
        }
        return position;
    }

    public static void removeContact() {
        System.out.println("** Remove the Contact **");
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        int position = getPosition(name);
        if (position >= 0) {
            contacts.remove(position);
            System.out.println("** Contact Removed **");
            showContacts();
        } else {
            System.out.printf("** No Contact with name %1$s found **\n", name);
        }
    }
    public static void searchContact() {
        System.out.println("** Search Contacts **");
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();

        int position = getPosition(name);
        if (position >= 0) {
            System.out.printf("** Found Contact: %1$s **\n", contacts.get(position));
        } else {
            System.out.printf("** No Contact with name %1$s found **\n", name);
        }
    }
    public static void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("You have no contacts");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println("\t" + contact);
            }
        }

    }
}
