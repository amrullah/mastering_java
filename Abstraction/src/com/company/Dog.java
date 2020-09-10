package com.company;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.printf("%1$s is eating! Chomp Chomp Chomp!\n", this.name);
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in ... Breathe out");
    }
}
