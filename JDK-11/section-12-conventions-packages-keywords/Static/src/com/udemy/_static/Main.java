package com.udemy._static; // protected keywords preceded by underscore (convention)

public class Main {
    public static int multiplier = 7; // public field of Main
    public static void main(String[] args) {
        /*
            // when numInstances is private, both getNumInstance() calls return 1
            // obvious result, as numInstances is a private field, each instance tracks the number separately
            // once it's a static var, that var is shared between all instances
            StaticTest oneInstance = new StaticTest("1st Instance");
            System.out.println(oneInstance.getName() + " is instance number " + oneInstance.getNumInstances());

            StaticTest twoInstance = new StaticTest("2nd Instance");
            System.out.println(twoInstance.getName() + " is instance number " + twoInstance.getNumInstances());

            StaticTest threeInstance = new StaticTest("3nd Instance");

            // note that we're not calling threeInstance.getNumInstance(); all share same var
            // bad practice, despite static field you should still call threeInstance
            System.out.println(threeInstance.getName() + " is instance number " + twoInstance.getNumInstances());

            // access static method on class directly (not dependent on an instance)
            // helps clarify when using static fields
            System.out.println(threeInstance.getName() + " is accessing a static method. Instances = "
                    + StaticTest.getStaticNumInstances());
        */

        // if multiply and multiplier are instance dependent, and no instance of Main is created
        // static methods like main() can't access non-static top-level vars/methods because
        // the non-static objects haven't been created when the static method is called
        int answer = multiply(6);
        System.out.println("Answer = " + answer);
        System.out.println("Multiplier = " + multiplier);
        // obviously there's no problem with a non-static accessing a static
    }

    public static int multiply(int number) {
        return number * multiplier;
    }
}
