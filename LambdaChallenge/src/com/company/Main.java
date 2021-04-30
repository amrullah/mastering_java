package com.company;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        System.out.println("\n---------------- Challenge 1 ----------------");
        challenge1();

        System.out.println("\n---------------- Challenge 2 ----------------");
	    challenge2();

        System.out.println("\n---------------- Challenge 3 ----------------");
	    challenge3();

        System.out.println("\n---------------- Challenge 4 ----------------");
        challenge4();
    }

    private static void challenge1() {
        // 1. Convert anonymous Runnable to Lambda
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");

                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };
        // answer:
        Runnable runnableLambda = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");

            Arrays.stream(parts).forEach(System.out::println);
        };
    }

    private static void challenge2() {
        /*
        Convert to lambda, and call that lambda with argument 1234567890
        public static String everySecondChar(String source) {
            StringBuilder returnVal = new StringBuilder();

            for (int i=0; i<source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i))
                }
            }
            return returnVal.toString();
        }
         */

        Function<String, String> everySecondCharLambda = s -> {
            StringBuilder returnVal = new StringBuilder();

            for (int i=0; i < s.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        String returnVal = everySecondCharLambda.apply("1234567890");
        System.out.println(returnVal);

    }

    private static void challenge3() {
        Supplier<String> iLoveJava = () -> {
            return "I Love Java!";
        };

        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);
    }

    private static void challenge4() {
        // Capitalize the first letter and sort

        List<String> names = Arrays.asList(
                "Amelia", "Olivia", "emily", "Isla", "Ava", "oliver", "Jack", "Charlie", "harry", "jacob"
        );

        List<String> sortedAndCapitalizedNames = names.stream()
                .map(s -> StringUtils.capitalize(s))
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedAndCapitalizedNames);

        // Print how many names begin with A
        long namesBeginWithACount = names.stream()
                .map(s -> StringUtils.capitalize(s))
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println(namesBeginWithACount);
    }
}
