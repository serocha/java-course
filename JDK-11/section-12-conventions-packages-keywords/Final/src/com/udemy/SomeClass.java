package com.udemy;

public class SomeClass {

    private static int classCounter = 0; // static is shared by all instances
    public final int instanceNumber; // instance dependent but can't be changed after constructor call
    private final String name;

    public SomeClass (String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
