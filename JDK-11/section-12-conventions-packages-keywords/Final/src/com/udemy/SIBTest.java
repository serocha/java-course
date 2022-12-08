package com.udemy;

public class SIBTest {
    public static final String owner;

    static {
        owner = "Tim";
        System.out.println("SIBTest static initialization block called");
    }

    public SIBTest() {
        System.out.println("SIBTest constructor called");
    }

    static {
        // bad practice as it may lead people to believe this block is called after constructor
        System.out.println("Second initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod() called");
    }
}
