package com.udemy;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    public void addExit(String direction, int locationID) {
        exits.put(direction, locationID);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits); // returns a copy so the internal map won't be affected
    }
}
