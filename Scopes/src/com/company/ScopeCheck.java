package com.company;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.printf("publicVar: %1$s\n", publicVar);
        System.out.printf("privateVar: %1$s\n", privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void timesTwo() {
        int privateVar = 2;

        for (int i=1; i<=10; i++) {
            System.out.printf("%1$s times %2$s is %3$s\n", i, privateVar, i*privateVar);
        }
        System.out.println((new InnerClass()).name);  //outer class can access inner class' private members too
    }

    public class InnerClass {
        public int privateVar = 3;
        private String name = "Awesome";

        public InnerClass() {
            System.out.printf("\nInnerClass.privateVar: %1$s\n", privateVar);
        }
        public void timesTwo() {
            // if privateVar was not declared here, InnerClass.privateVar would have been used here
            // if InnerClass.privateVar was not declared either, then ScopeCheck.privateVar would have been used
            int privateVar = 2;
            System.out.println("inner class timesTwo");
            for (int i=1; i<=10; i++) {
                System.out.printf("%1$s times %2$s is %3$s\n", i, privateVar, i*privateVar);
            }
        }
        public void timesOne() {
            int one = ScopeCheck.this.privateVar;  // check this out, this is how one should access outer class's member
            System.out.println("\ninner class timesOne");
            for (int i=1; i<=10; i++) {
                System.out.printf("%1$s times %2$s is %3$s\n", i, one, i*one);
            }
        }
    }


}
