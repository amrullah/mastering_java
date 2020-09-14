package com.amrullah.series;

import java.util.ArrayList;

public class Series {
    public static int nSum(int n) {
        int sum = 0;
        for (int i=0; i<=n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n <= 2) {
            return n;
        }
        int factorial = 1;
        for (int i=1; i<=n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        ArrayList<Integer> fibSequence = new ArrayList<>();
        fibSequence.add(0, 0);
        fibSequence.add(1, 1);

        for (int i=2; i<=n; i++) {
            int currentFibNumber = fibSequence.get(i-1) + fibSequence.get(i-2);
            fibSequence.add(i, currentFibNumber);

        }
        return fibSequence.get(n);
    }
}
