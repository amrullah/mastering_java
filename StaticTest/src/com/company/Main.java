package com.company;

public class Main {

    public static void main(String[] args) {
	    StaticTest instance1 = new StaticTest("1st instance");
        System.out.printf("%1$s is instance number %2$s\n", instance1.getName(), StaticTest.getNumInstances());

        StaticTest instance2 = new StaticTest("2nd instance");
        System.out.printf("%1$s is instance number %2$s\n", instance2.getName(), instance2.getNumInstances());

        StaticTest instance3 = new StaticTest("3rd instance");
        System.out.printf("%1$s is instance number %2$s\n", instance3.getName(), StaticTest.getNumInstances());
    }
}
