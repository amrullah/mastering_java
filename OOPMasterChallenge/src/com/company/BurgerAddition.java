package com.company;

public class BurgerAddition {
    private String name;
    private double price;

    public BurgerAddition(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return this.name;
    }

    public double getPrice() {
        return price;
    }
}
