package com.udemy;

public class DogMain {
    // a class to hold a main() method to demonstrate subclass equality issues
    public static void main(String[] args) {
        // Labrador is instanceof Dog
        Labrador rover = new Labrador("Rover");
        // Dog isn't instanceof Labrador
        Dog rover2 = new Dog("Rover");

        // if Labrador also overrides equals(), then there isn't reverse equality in the second case
        // don't override in subclasses, one way is to declare the super equals() as final
        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }
}
