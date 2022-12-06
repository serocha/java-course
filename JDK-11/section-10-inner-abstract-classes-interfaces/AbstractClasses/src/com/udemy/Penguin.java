package com.udemy;

public class Penguin extends Bird {

    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println(getName() + " isn't very good at that...");
    }

    public void swim() {
        System.out.println(getName() + " is swimming");
    }
}
