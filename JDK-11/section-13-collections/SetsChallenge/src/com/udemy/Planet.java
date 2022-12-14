package com.udemy;

public class Planet extends HeavenlyBody {

    private final String bodyType = "planet";

    public Planet(String name, String bodyType, double orbitalPeriod) {
        super(name, bodyType, orbitalPeriod);
    }
}
