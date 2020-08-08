package com.company;

public class Main {

    public static void main(String[] args) {
        int myMinIntValue = Integer.MIN_VALUE;
        int myMaxIntValue = Integer.MAX_VALUE;

        System.out.println("Busted MAX value = " + (myMaxIntValue + 1));  // demonstrating overflow
        System.out.println("Busted MIN value = " + (myMinIntValue - 1));  // demonstrating underflow

        byte myMinByteValue = Byte.MIN_VALUE;
        byte myMaxByteValue = Byte.MAX_VALUE;
        System.out.println("Byte Minimum Value = " + myMinByteValue);
        System.out.println("Byte Maximum Value = " + myMaxByteValue);

        short myMinShortValue = Short.MIN_VALUE;
        short myMaxShortValue = Short.MAX_VALUE;
        System.out.println("Short Minimum Value = " + myMinShortValue);
        System.out.println("Short Maximum Value = " + myMaxShortValue);

        System.out.println("Integer Minimum Value = " + myMinIntValue);
        System.out.println("Integer Maximum Value = " + myMaxIntValue);

        // long myLongValue = 1000L;  even if L was not provided, Java is smart enough to convert int literal to long
        long myMinLongValue = Long.MIN_VALUE;
        long myMaxLongValue = Long.MAX_VALUE;
        System.out.println("Long Minimum Value = " + myMinLongValue);
        System.out.println("Long Maximum Value = " + myMaxLongValue);

        short bigShortLiteral = 32767;
        int myTotal = (myMinIntValue / 2);
        // by default a number literal is considered as int, so if you remove the typecasts (byte) or (short)
        // java will consider the value of (myMin###Value / 2) expression as integer, and complain about possible lossy conversion
        byte myNewByteValue = (byte) (myMinByteValue / 2);
        short myNewShortValue = (short) (myMinShortValue / 2);
    }
}
