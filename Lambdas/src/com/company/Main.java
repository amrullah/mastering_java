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

//        String sillyString = doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                return s1.toUpperCase() + " " + s2.toUpperCase();
//            }
//        }, "Ertugrul", "Samsa");

        // or
        UpperConcat uc = (s1, s2) -> {
            String result = s1.toUpperCase() + " " + s2.toUpperCase();
            return result;
        };
        String sillyString = doStringStuff(uc, "Ertugrul", "Samsa");
        System.out.println(sillyString);

        AnotherClass anotherClass = new AnotherClass();
        String s = anotherClass.doSomething();
        System.out.println(s);
    }

    private static void doEmployeeStuff() {
        Employee john = new Employee("Ertugrul Ghazi", 30);
        Employee tim = new Employee("Saadetin Kobek", 21);
        Employee sunny = new Employee("Gundogdu Bey", 21);
        Employee jack = new Employee("Tughtekin", 40);
        Employee snow = new Employee("Suleiman Shah", 22);

        List<Employee> employees = Arrays.asList(john, tim, sunny, jack, snow);

//        Collections.sort(employees, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee employee1, Employee employee2) {
//                return employee1.getName().compareTo(employee2.getName());
//            }
//        });
        // or
//        Collections.sort(employees, (e1, e2) -> {  // can leave the types out
//            return e1.getName().compareTo(e2.getName());
//        });
        // or
//        Collections.sort(employees, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        // or
//        Collections.sort(employees, Comparator.comparing(Employee::getName));
        // or
//        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        // or
        employees.sort(Comparator.comparing(Employee::getName));

        System.out.println(employees);

        System.out.println("--------------------------------");
        for (Employee employee : employees) {
            // this works because the loop variable employee is effectively final inside the for each block
            System.out.println(employee.getName());
            new Thread(() -> System.out.println(employee.getAge())).start();
        }


        System.out.println("--------------------------------");
        // declaring employee variable outside makes it effectively non-final
        Employee employee;
        for (int i = 0; i < employees.size(); i++) {
            employee = employees.get(i);
            System.out.println(employee.getName());
            // you will get: java: local variables referenced from a lambda expression must be final or effectively final
//            new Thread(() -> System.out.println(employee.getAge())).start();
        }
    }

    public static String doStringStuff(UpperConcat uc, String s1, String s2) {
        return uc.upperAndConcat(s1, s2);
    }
}

class Employee {
    private final String name;
    private final int age;

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


interface UpperConcat {
    String upperAndConcat(String s1, String s2);
}

class AnotherClass {
    public String doSomething() {
//        UpperConcat uc = (s1, s2) -> {
//            // not treated as a separate class. Just treated like a block of code. So the answer will be AnotherClass
//            System.out.println("The Lambda Expression class' name is " + getClass().getSimpleName());
//            return s1.toUpperCase() + " " + s2.toUpperCase();
//        };

        final int i = 0;  // needs to be final so that it can be used in the anonymous class
        {
            UpperConcat uc = new UpperConcat() {
                @Override
                public String upperAndConcat(String s1, String s2) {
                    System.out.println("i = " + i);
                    return s1.toUpperCase() + " " + s2.toUpperCase();
                }
            };
//            i++;
            System.out.println("i = " + i);
            System.out.println("The AnotherClass class' name is " + getClass().getSimpleName());
            return Main.doStringStuff(uc, "Osman", "Bamsi");
        }

//        int j = 0;
////        j++;  // this won't be allowed since the variable is being used in lambda
//        UpperConcat uc2 = (s1, s2) -> {
//            System.out.println("j = " + j);  // this will work fine
//            return s1.toUpperCase() + " " + s2.toUpperCase();
//        };

        // can't use s1 and s2 outside the lambda body either

//        System.out.println("The AnotherClass class' name is " + getClass().getSimpleName());
//        return Main.doStringStuff(new UpperConcat() {
//            @Override
//            public String upperAndConcat(String s1, String s2) {
//                System.out.println("The AnotherClass class' name is " + getClass().getSimpleName());  // null
//                return s1.toUpperCase() + " " + s2.toUpperCase();
//            }
//        }, "Osman", "Bamsi");
    }

    public void printValue() {
        int number = 25;

        Runnable r = () -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The Value is " + number);  // will print 25 even if the outer scope is long destroyed
        };

        new Thread(r).start();
    }
}