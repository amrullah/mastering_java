package com.company;

public class Main {

    public static void main(String[] args) {
        Account myAccount = new Account("12345", 0.0, "Amrullah",
                "amrullah@zunzunia.com", "100");
        myAccount.withdraw(100.0);
        myAccount.deposit(50.0);
        myAccount.withdraw(100.0);
        myAccount.deposit(51.0);
        myAccount.withdraw(100.0);

        Account someAccount = new Account();  // default constructor

        Account newAccount = new Account("Rafi", "rafi@yahoo.com", "123456");

        VipCustomer customer1 = new VipCustomer();
        VipCustomer customer2 = new VipCustomer("Amrullah", "ABC.com");
        VipCustomer customer3 = new VipCustomer("Barkat", 12.0, "ABCD.com");

        System.out.println(customer3.getCreditLimit());
        System.out.println(customer3.getEmailAddress());
        System.out.println(customer3.getName());

    }
}
