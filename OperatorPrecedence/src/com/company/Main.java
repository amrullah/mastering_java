package com.company;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        double var1 = 20.0;
        double var2 = 80.0;
        // if parenthesis is missed then, multiplication would happen first, then the addition of var1 with the product
        // of multiplication
        double intermediate = (var1 + var2) * 100.0;
        double remainder = intermediate % 40.0;

        boolean hasNoRemainder = remainder == 0;

        System.out.println("Has No Remainder: " + hasNoRemainder);

        if (!hasNoRemainder) {
            System.out.println("Got some remainder!");
        }

        String messaeg = "Hello";
        for (int i=0; i<messaeg.length(); i++) {
            System.out.println(messaeg.charAt(i+1));
        }
    }
}
