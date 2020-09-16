package com.company;

public class Main {

    public static void main(String[] args) {
	    Account account = new Account("Amrullah");

	    account.deposit(1000);
	    account.withdraw(500);
        account.withdraw(-200);
        account.deposit(-20);

        account.calculateBalance();

        System.out.printf("Balance in account is %1$s\n", account.getBalance());

    }
}
