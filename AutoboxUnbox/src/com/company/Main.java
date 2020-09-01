package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Integer myIntValue = 56;  // equivalent to Integer myIntValue = Integer.valueOf(56);
	    int myInt = myIntValue;  // equivalent to int myInt = Integer.intValue();

        ArrayList<Double> myDoubleArray = new ArrayList<>();

        for (double d=0.0; d <= 10.0; d += 0.5) {
            myDoubleArray.add(d);  // note
        }

        for (double d : myDoubleArray) {  // note
            System.out.println(d);
        }
    }
}
