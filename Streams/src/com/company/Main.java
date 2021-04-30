package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71"
        );

        List<String> gNumbers = new ArrayList<>();

        someBingoNumbers.forEach(number -> {
            if(number.toUpperCase().startsWith("G")) {
                gNumbers.add(number);
            }
        });

        gNumbers.sort(String::compareTo);
        gNumbers.forEach(System.out::println);

        // above stuff can be done in one line as shown below
        System.out.println();
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);  // this is not the same forEach as that in Iterable interface

        System.out.println();
        // creating a Stream from scratch
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);

        System.out.println("--------------------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        System.out.println("----------- flatmap method ---------------------");

        Employee john = new Employee("Ertugrul Ghazi", 30);
        Employee tim = new Employee("Saadetin Kobek", 50);
        Employee sunny = new Employee("Gundogdu Bey", 33);
        Employee jack = new Employee("Tughtekin Ahmak", 30);
        Employee snow = new Employee("Suleiman Shah", 55);
        Employee jay = new Employee("Tangut Wicked", 23);

        Department hr = new Department("Human Resources");
        hr.addEmployee(john);
        hr.addEmployee(tim);
        hr.addEmployee(sunny);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(jack);
        accounting.addEmployee(snow);
        accounting.addEmployee(jay);

        List<Department> departments = Arrays.asList(hr, accounting);

        // will list all the employees
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())  // note this
                .forEach(System.out::println);

        System.out.println("----------- collect method ---------------------");
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(Collectors.toList());

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        System.out.println();
        List<String> sortedGNumbers2 = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
//                .collect(() -> new ArrayList<String>(), (list, item) -> list.add(item), (list1, list2) -> list1.addAll(list2))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }
        System.out.println();

        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        System.out.println(groupedByAge);

        System.out.println("----------- reduce method ---------------------");

        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

    }
}
