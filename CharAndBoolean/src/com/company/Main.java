package com.company;

public class Main {

    public static void main(String[] args) {
	    char myChar = 'D';
        char myDecimalChar = 68;
	    char myUnicodeChar = '\u0044';

        System.out.println(myChar);
        System.out.println(myDecimalChar);
        System.out.println(myUnicodeChar);

        char fractionChar = '\u00BC';
        char copyrightChar = '\u00A9';

        System.out.println(fractionChar);
        System.out.println(copyrightChar);

        boolean myTrueBooleanValue = true;
        boolean myFalseBooleanValue = false;
    }
}
