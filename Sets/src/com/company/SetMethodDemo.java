package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class SetMethodDemo {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        IntStream.rangeClosed(1, 100).forEach(i -> {  // using lambda
            squares.add(i * i);
            cubes.add(i * i * i);
        });
        /*
        IntStream.rangeClosed(1, 100).forEach(new IntConsumer() {  // using anonymous class
            @Override
            public void accept(int i) {
                squares.add(i * i);
                cubes.add(i * i * i);
            }
        });
        */
        System.out.printf("There are %1$s squares and %2$s cubes\n", squares.size(), cubes.size());

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);  // union operation
        System.out.printf("Union of squares and cubes contains %1$s elements\n", union.size());

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);  // intersection operation
        System.out.printf("Intersection of squares and cubes contains %1$s elements\n", intersection.size());
        System.out.println();

        System.out.printf("Intersection Elements: %1$s\n", intersection);

        // converting array to set
        String sentence = "One day in the year of the fox";
        // split returns an array, which is then converted to ArrayList by asList(). Which can be passed to HashSet()
        // constructore or addAll() method
        Set<String> words = new HashSet<>(Arrays.asList(sentence.split(" ")));

        // asymmetric differences:
        Set<String> natureWords = new HashSet<>(Arrays.asList(
                new String[]{"all", "nature", "is", "but", "art", "unknown", "to", "thee"}
        ));
        Set<String> errWords = new HashSet<>(Arrays.asList(
                "to", "err", "is", "human", "but", "to", "forgive", "is", "divine"
        ));

        System.out.println("natureWords take errWords:");
        Set<String> diff1 = new HashSet<>(natureWords);
        diff1.removeAll(errWords);  // all the words of natureWords minus the words common with errWords
        System.out.println(diff1);

        System.out.println("errWords take natureWords:");
        Set<String> diff2 = new HashSet<>(errWords);
        diff2.removeAll(natureWords);  // all the words of errWords minus the words common with natureWords
        System.out.println(diff2);

        // symmetric difference can be calculated by taking union and removing the intersection
        Set<String> symDiff = new HashSet<>(natureWords);
        symDiff.addAll(errWords);

        Set<String> toRemove = new HashSet<>(natureWords);
        toRemove.retainAll(errWords);
        symDiff.removeAll(toRemove);  // have all the words belonging to either set, minus the common ones
        System.out.println("Symmetric Difference:");
        System.out.println(symDiff);

        // testing whether all the elements of a set are present in a given subset
        if (natureWords.containsAll(errWords)) {
            System.out.println("errWords is a subset of natureWords");
        } else {
            System.out.println("errWords is not a subset of natureWords");
        }
        if (natureWords.containsAll(toRemove)) {
            System.out.println("toRemove is a subset of natureWords");
        }
    }
}
