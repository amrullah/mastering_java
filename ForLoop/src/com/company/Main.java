package com.company;

public class Main {

    public static void main(String[] args) {
        double amount = 10000.0;
        for (double interestRate = 2.0; interestRate <= 8.0; interestRate++){
            System.out.printf("10,000 at %.2f %% interest = %.2f\n", interestRate,
                    calculateInterest(amount, interestRate));
        }
        System.out.println("");
        for (double interestRate = 8.0; interestRate >= 2.0; interestRate--){
            System.out.printf("10,000 at %.2f %% interest = %.2f\n", interestRate,
                    calculateInterest(amount, interestRate));
        }
        System.out.println("");

        int primeNumbersFound = 0;
        for (int i=10; i <= 20; i++) {
            if (primeNumbersFound >= 3) {
                System.out.println("Exiting as 3 prime numbers are found");
                break;
            }
            if ( isPrime(i) ) {
                System.out.printf("Number %1$s is prime\n", i);
                primeNumbersFound++;
            }
        }
    }
    public static double calculateInterest(double amount, double interestRate) {
        return amount * interestRate / 100.0;
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i=2; i < n/2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
