package com.company;

public class Main {

    public static void main(String[] args) {
	    Dog dog = new Dog("Tommy");
		Bird parrot = new Parrot("Meethu");
		Penguin penguin = new Penguin("Pingu");
//	    dog.eat();
//	    dog.breathe();
		doAnimalStuff(dog);
		doBirdStuff(parrot);
		doBirdStuff(penguin);
    }

	private static void doBirdStuff(Bird bird) {
    	doAnimalStuff(bird);
    	bird.fly();
	}

	private static void doAnimalStuff(Animal animal) {
    	animal.eat();
    	animal.breathe();
	}
}
