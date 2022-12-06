package com.udemy;

public abstract class Animal {
    // can mix regular fields/methods with abstract
    private String name;

    public Animal (String name) {
        this.name = name;
    }

    public abstract void eat(); // note that methods are defined without specifying how to perform them
    public abstract void breathe();

    public String getName() {
        return name;
    }
}
