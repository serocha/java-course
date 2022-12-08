package com.udemy;

public class Main {

    public static void main(String[] args) {

//        SomeClass one = new SomeClass("One");
//        SomeClass two = new SomeClass("Two");
//        SomeClass three = new SomeClass("Three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//        // one.instanceNumber = 4; won't compile
//        System.out.println(Math.PI); // public static final
//        // Math m = new Math(); final class
//
//        int pass = 546329;
//        Password password = new Password(pass);
//        password.storePassword();
//
//        password.letMeIn(1);
//        password.letMeIn(436572);
//        password.letMeIn(-5467);
//        password.letMeIn(546329);
//        System.out.println();
//        System.out.println();

//        ExtendedPassword tampering = new ExtendedPassword(pass);
//        tampering.letMeIn(1);
//        tampering.letMeIn(436572);
//        tampering.letMeIn(-5467);
//        tampering.letMeIn(546329);
//        tampering.storePassword(); // bypass encryption

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);

    }
}
