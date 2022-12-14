package com.udemy;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        this.exits = exits; // could use new HashMap<>(exits) to be extra safe but have to include extra code for null
        if (locationID != 0) {
            this.exits.put("Q", 0);
        }
    }
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<>(exits); // returns a copy so the internal map won't be affected
    }
}
