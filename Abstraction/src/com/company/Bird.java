package com.company;

public abstract class Bird extends Animal implements CanFly {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.printf("%1$s is eating! Chuck Chuck Chuck!\n", this.name);
    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, Breathe out");
    }

}
