package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i=0; i!=6; i++) {
            System.out.println(i);
        }
        System.out.println("");

        int i = 0;
        while (i != 6) {
            System.out.println(i);
            i++;
        }
        System.out.println("");

        i = 0;
        do {  // executes at least once, even if the condition was false
            System.out.println(i);
            i++;
        } while (i != 6);
        
    }
}
