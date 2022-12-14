package com.udemy;

public class DwarfPlanet extends HeavenlyBody {

    private final String bodyType;

    public DwarfPlanet(String name, String bodyType, double orbitalPeriod) {
        super(name, bodyType, orbitalPeriod);
        this.bodyType = bodyType;
    }
}
