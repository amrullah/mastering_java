package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("Ertugrul Ghazi", 30);
        Employee tim = new Employee("Saadetin Kobek", 50);
        Employee sunny = new Employee("Gundogdu Bey", 33);
        Employee jack = new Employee("Tughtekin", 30);
        Employee snow = new Employee("Suleiman Shah", 55);
        Employee jay = new Employee("Tangut", 23);

        List<Employee> employees = Arrays.asList(john, tim, sunny, jack, snow, jay);

        employees.forEach(employee -> {
            System.out.println(employee.getName());
            System.out.println(employee.getAge());
        });

        Predicate<Employee> ageCondition = employee -> employee.getAge() > 30;

        System.out.println("\nEmployees above 30:");
        printEmployeesByAge(employees, ageCondition);

        System.out.println("\nEmployees below 30:");
        printEmployeesByAge(employees, employee -> employee.getAge() <= 30);

        System.out.println("\nEmployees above 45:");
        printEmployeesByAge(employees, new Predicate<Employee>() {  // also possible this way
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 45;
            }
        });

        System.out.println();
        IntPredicate gt15 = i -> i > 15;
        IntPredicate lt100 = i -> i < 100;

        System.out.println(gt15.test(10));
        System.out.println(gt15.test(20));

        System.out.println(gt15.and(lt100).test(60));  // chaining predicates

        // Supplier interface
        Supplier<Integer> randomSupplier = () -> (new Random()).nextInt(1000);

        System.out.println("\nRandom Numbers:");
        for (int i=0; i < 10; i++) {
            System.out.println(randomSupplier.get());
        }
    }

    private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> agePredicate) {
        for (Employee employee : employees) {
            if (agePredicate.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }
}
