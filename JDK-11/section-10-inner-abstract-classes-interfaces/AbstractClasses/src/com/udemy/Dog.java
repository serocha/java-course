package com.udemy;

public class Dog extends Animal {
// extends as normal, but requires the abstract methods be implemented
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        // getName() is available from the super class
        System.out.println(getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println(getName() + " is breathing");
    }
}
