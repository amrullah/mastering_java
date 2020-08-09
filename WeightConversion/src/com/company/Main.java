package com.company;

public class Main {
    static final double POUND_TO_KG_CONVERSION_RATIO = 0.4536;
    static final double KG_TO_POUND_CONVERSION_RATIO = 2.2046;

    public static void main(String[] args) {
	    double weightInPounds = 200.0;
	    double weightInKilograms = convertToKilogram(weightInPounds);
        System.out.printf("%1$f Pounds = %2$f Kilograms%n", weightInPounds, weightInKilograms);

        weightInKilograms = 120.0;
        weightInPounds = convertToPound(weightInKilograms);
        System.out.printf("%1$f Kilograms = %2$f Pounds%n", weightInKilograms, weightInPounds);
    }

    private static double convertToKilogram(double weightInPounds) {
        return weightInPounds * Main.POUND_TO_KG_CONVERSION_RATIO;
    }

    private static double convertToPound(double weightInKgs) {
        return weightInKgs * Main.KG_TO_POUND_CONVERSION_RATIO;
    }
}
