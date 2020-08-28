package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int myIntValue = 10;
	    int anotherIntValue = myIntValue;  // copies the value

        System.out.println(myIntValue);  // 10
        System.out.println(anotherIntValue);  // 10

        anotherIntValue += 1;

        System.out.println(myIntValue);  // 10
        System.out.println(anotherIntValue);  // 11

        int[] myIntArray = new int[5];
        int[] anotherIntArray = myIntArray;  // copies the reference

        System.out.println(Arrays.toString(myIntArray));  // [0, 0, 0, 0, 0]
        System.out.println(Arrays.toString(anotherIntArray));  // [0, 0, 0, 0, 0]

        anotherIntArray[0] = 1;

        System.out.println(Arrays.toString(myIntArray));  // [1, 0, 0, 0, 0]
        System.out.println(Arrays.toString(anotherIntArray));  // [1, 0, 0, 0, 0]

        anotherIntArray = new int[] {4, 5, 6, 7, 8};  // due to usage of new key word, anotherIntArray was de-referenced from existing array and pointed to newly created array
        modifyArray(myIntArray);

        System.out.println(Arrays.toString(myIntArray));  // [2, 0, 0, 0, 0]
        System.out.println(Arrays.toString(anotherIntArray));  // [2, 0, 0, 0, 0]
    }

    private static void modifyArray(int[] array) {
        array[0] = 2;
        array = new int[] {1, 2, 3, 4, 5};  // de-reference from myIntArray and point array variable to newly created array
    }
}
