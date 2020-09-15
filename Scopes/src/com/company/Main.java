package com.company;

public class Main {

    public static void main(String[] args) {
	    String privateVar = "this is private to main()";

	    ScopeCheck scopeInstance = new ScopeCheck();

        System.out.printf("scopeInstance.privateVar = %1$s\n", scopeInstance.getPrivateVar());
        System.out.println(privateVar);

        scopeInstance.timesTwo();

        ScopeCheck.InnerClass innerObject = scopeInstance.new InnerClass();
        innerObject.timesTwo();
        innerObject.timesOne();
    }
}
