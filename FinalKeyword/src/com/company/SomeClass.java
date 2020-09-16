package com.company;

public class SomeClass {
    private static int classCounter = 0;
    public final int instanceNumber;
    private final String name;
    public static final String topPlayer;

    static {
        // called before the first object's constructor gets called
        topPlayer = "Messi";
        System.out.println("topPlayer assigned in static initialization block");
    }
    static {
        System.out.println("more than one static blocks can exist");
        // even this will get called before the first call to constructor
    }
    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;  // can't be reassigned after this
        System.out.printf("%1$s created with instance number %2$s\n", this.name, this.instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}