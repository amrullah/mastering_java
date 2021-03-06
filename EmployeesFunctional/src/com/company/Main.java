package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("Ertugrul Ghazi", 30);
        Employee tim = new Employee("Saadetin Kobek", 50);
        Employee sunny = new Employee("Gundogdu Bey", 33);
        Employee jack = new Employee("Tughtekin Ahmak", 30);
        Employee snow = new Employee("Suleiman Shah", 55);
        Employee jay = new Employee("Tangut Wicked", 23);

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

        // Function interface

        System.out.println();
        employees.forEach(employee -> {
            String lastName = employee.getName().split(" ")[1];
            System.out.println("Last Name: " + lastName);
        });

        // above can be achieved using Function interface, as shown below:
        System.out.println();

        Function<Employee, String> getLastName = employee -> employee.getName().split(" ")[1];

        employees.forEach(employee -> System.out.println("Last Name: " + getLastName.apply(employee)));

        // Chaining Functions
        System.out.println();
        Function<String, String> getFirstName = name -> name.split(" ")[0];
        Function<Employee, String> getUpperCase = employee -> employee.getName().toUpperCase();

        Function<Employee, String> chainedFunction = getUpperCase.andThen(getFirstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        // BiFunction
        BiFunction<String, Employee, String>  concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = getUpperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));


        // Unary operators
        System.out.println();
        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

        // Consumer chaining
        Consumer<String> c1 = s -> s.toUpperCase();
        Consumer<String> c2 = s -> System.out.println(s);

        // the result of c1.accept() is lost, since consumers don't return anything.
        c1.andThen(c2).accept("Hello World");  // Hello World


    }

    private static void printEmployeesByAge(List<Employee> employees, Predicate<Employee> agePredicate) {
        for (Employee employee : employees) {
            if (agePredicate.test(employee)) {
                System.out.println(employee.getName());
            }
        }
    }

}
