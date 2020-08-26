package com.company;

public class Burger {
    private String name;
    private String breadRollType;
    private String meat;
    private BurgerAddition addition1;
    private BurgerAddition addition2;
    private BurgerAddition addition3;
    private BurgerAddition addition4;
    private double basePrice;

    public Burger(String name, String breadRollType, String meat, double basePrice) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.basePrice = basePrice;
    }

    public void addAddition1(String name, double price) {
        this.addition1 = new BurgerAddition(name, price);
    }
    public void addAddition2(String name, double price) {
        this.addition2 = new BurgerAddition(name, price);
    }
    public void addAddition3(String name, double price) {
        this.addition3 = new BurgerAddition(name, price);
    }
    public void addAddition4(String name, double price) {
        this.addition4 = new BurgerAddition(name, price);
    }

    public double totalPrice() {
        double totalPrice = this.basePrice;
        System.out.printf("%1$s hamburger on %2$s bread costs %3$s\n", this.name, this.breadRollType, this.basePrice);

        if (this.addition1 != null) {
            totalPrice += this.addition1.getPrice();
            System.out.printf("Added %1$s for %2$s\n", this.addition1, this.addition1.getPrice());
        }
        if (this.addition2 != null) {
            totalPrice += this.addition2.getPrice();
            System.out.printf("Added %1$s for %2$s\n", this.addition2, this.addition2.getPrice());
        }
        if (this.addition3 != null) {
            totalPrice += this.addition3.getPrice();
            System.out.printf("Added %1$s for %2$s\n", this.addition3, this.addition3.getPrice());
        }
        if (this.addition4 != null) {
            totalPrice += this.addition4.getPrice();
            System.out.printf("Added %1$s for %2$s\n", this.addition4, this.addition4.getPrice());
        }

        return totalPrice;
    }
}
