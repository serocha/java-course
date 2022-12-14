package com.udemy;

/*
    Only add/edit code where it is stated in the description.
*/

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon); // doesn't restrict satellite types
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    @Override
    public final boolean equals (Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            return this.key.equals(((HeavenlyBody)obj).getKey());
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.getKey().hashCode();
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name,bodyType);
    }

    public enum BodyTypes {
        PLANET,
        DWARF_PLANET,
        MOON
    }

    @Override
    public String toString() {
        return this.key.getName() + ": " + this.key.getBodyType() + ", " + this.orbitalPeriod;
    }

    public static final class Key {

        private final String name;
        private final BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + this.bodyType.hashCode() + 15; // arbitrary number
        }

        @Override
        public boolean equals (Object obj) {
            if (obj != null) {
                    return this.name.equals(((Key) obj).getName()) && this.bodyType == ((Key) obj).getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return name + ": " + bodyType;
        }
    }
}