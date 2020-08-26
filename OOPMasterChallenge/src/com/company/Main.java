package com.company;

public class Main {

    public static void main(String[] args) {
        Burger burger = new Burger("Basic", "White", "Sausage", 3.5);
        burger.addAddition1("Tomato", .75);
        burger.addAddition2("Cheese", .75);
        burger.addAddition3("Lettuce", .75);
        System.out.println(burger.totalPrice());

        HealthyBurger healthyBurger = new HealthyBurger("Beef", 5.0);
        healthyBurger.addAddition1("Egg", 2.0);
        healthyBurger.addAddition5("Lentils", 2.0);
        System.out.println(healthyBurger.totalPrice());

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.addAddition1("Whatever", 0.0);
        System.out.println(deluxeBurger.totalPrice());

    }
}
