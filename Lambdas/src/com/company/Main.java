package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//      1.  passing an object implementing runnable interface
	    /*new Thread(new CodeToRun()).start();*/
//      2. passing an anonymous runnable object
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from Runnable");
            }
        }).start();
         */
//      3. Lambda expression
        new Thread(()-> {
            System.out.println("Printing from runnable");
        }).start();

        doEmployeeStuff();
    }

    private static void doEmployeeStuff() {
        Employee john = new Employee("Ertugrul Ghazi", 30);
        Employee tim = new Employee("Saadetin Kobek", 21);
        Employee sunny = new Employee("Gundogdu Bey", 21);
        Employee jack = new Employee("Tughtekin", 40);
        Employee snow = new Employee("Suleiman Shah", 22);

        List<Employee> employees = Arrays.asList(john, tim, sunny, jack, snow);

//        Collections.sort(employees, (e1, e2) -> {
//            return e1.getName().compareTo(e2.getName());
//        });
        // or
        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        // or
//        Collections.sort(employees, Comparator.comparing(Employee::getName));

        System.out.println(employees);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
class CodeToRun implements Runnable {
    @Override
    public void run() {
        System.out.println("Printing from Runnable");
    }
}
