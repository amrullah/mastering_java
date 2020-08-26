package com.company;

public class HealthyBurger extends Burger {
    private String breadRollType = "Brown Rye bread";
    private BurgerAddition addition5;
    private BurgerAddition addition6;

    public HealthyBurger(String meat, double basePrice) {
        super("Healthy Burger", "Brown Rye bread", meat, basePrice);
    }
    public void addAddition5(String name, double price) {
        this.addition5 = new BurgerAddition(name, price);
    }
    public void addAddition6(String name, double price) {
        this.addition6 = new BurgerAddition(name, price);
    }

    @Override
    public double totalPrice() {
        double totalPrice = super.totalPrice();

        if (this.addition5 != null) {
            totalPrice += this.addition5.getPrice();
            System.out.printf("Added %1$s for %2$s\n", this.addition5, this.addition5.getPrice());
        }

        if (this.addition6 != null) {
            totalPrice += this.addition6.getPrice();
            System.out.printf("Added %1$s for %2$s\n", this.addition6, this.addition6.getPrice());
        }

        return totalPrice;
    }
}
