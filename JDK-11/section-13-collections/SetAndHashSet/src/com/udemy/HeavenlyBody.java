package com.udemy;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites; // less specific declarations allow greater flexibility

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addMoon(HeavenlyBody moon) {
        this.satellites.add(moon);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        // note that this class doesn't have to worry about comparisons to subclasses because
        // the class itself is declared final; additionally String is final, and we're comparing Strings
        if (this == obj) {
            return true;
        }
        // prevent subclasses from returning true
        System.out.println("Object.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ( obj == null || obj.getClass() != this.getClass() ) {
            return false;
        }
        // for our criteria, solely comparing names works
        String objName = ((HeavenlyBody) obj).getName(); // cast and test
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 57; // adding a number to the string to generate
    }
}
