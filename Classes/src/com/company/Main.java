package com.company;

public class Main {

    public static void main(String[] args) {
	    Car porsche = new Car();
	    Car ford = new Car();

	    porsche.setModel("Carrera");
        System.out.println(porsche.getModel());

        ford.setModel("ABC");
        System.out.println(ford.getModel());
    }
}
