package com.udemy;

public abstract class Sport {
    private final String name;

    public Sport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
