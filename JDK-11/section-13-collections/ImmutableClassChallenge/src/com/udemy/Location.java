package com.udemy;

// the assignment is to take an existing code segment and make it immutable
import java.util.HashMap;
import java.util.Map;

// got rid of setters, made fields private and final, altered access to mutable objects, made class final
public final class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        if (exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
            this.exits.put("Q", 0);
        } else {
            this.exits = new HashMap<>();
        }
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits);
    }

}
