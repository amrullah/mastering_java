package com.company;

public class DeluxeBurger extends Burger {
    public DeluxeBurger() {
        super("Deluxe Burger", "White", "Sausage & Bacon", 14.0);
        super.addAddition1("Chips", 2.0);
        super.addAddition2("Drink", 2.5);
    }

    @Override
    public void addAddition1(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }

    @Override
    public void addAddition2(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }

    @Override
    public void addAddition3(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }

    @Override
    public void addAddition4(String name, double price) {
        System.out.println("Cannot add additional items to Deluxe Burger");
    }
}
