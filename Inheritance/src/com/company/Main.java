package com.company;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("Animal", 1, 1, 1, 1);
        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
        dog.eat();
        dog.chew();
        dog.walk();
        dog.run();
    }
}
