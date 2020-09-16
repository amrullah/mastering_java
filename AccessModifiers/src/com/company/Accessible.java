package com.company;

interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}

/*
What is the visibility of:
1. Accessible interface
2. methodA()
3. methodB() and methodC()
4. SOME_CONSTANT?

Answers:
1. package-protected
2, 3, 4. public
 */