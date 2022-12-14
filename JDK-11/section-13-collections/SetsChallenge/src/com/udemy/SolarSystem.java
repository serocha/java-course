package com.udemy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class SolarSystem {

    private Map<String, HeavenlyBody> solarSystem;
    private final Set<HeavenlyBody> planets;
    private final Set<HeavenlyBody> moons;
    private final Set<HeavenlyBody> dwarfPlanets;

    public SolarSystem() {
        // unessential this usage but I like it
        this.solarSystem = new HashMap<>();
        this.planets = new HashSet<>();
        this.moons = new HashSet<>();
        this.dwarfPlanets = new HashSet<>();
    }

    public Map<String, HeavenlyBody> getSolarSystem() {
        return new HashMap<>(solarSystem);
    }

    void addToSolarSystem(HeavenlyBody heavenlyBody) {

    }

    Set<HeavenlyBody> getPlanets() {
        return new HashSet<>(planets);
    }

    Set<HeavenlyBody> getMoons() {
        return new HashSet<>(moons);
    }

    Set<HeavenlyBody> getDwarfPlanets() {
        return new HashSet<>(dwarfPlanets);
    }

    void createHeavenlyBody(String name, String bodyType, double orbitalPeriod) {
        createHeavenlyBody(name, bodyType, orbitalPeriod, "");
    }

    void createHeavenlyBody(String name, String bodyType, double orbitalPeriod, String orbitalParent) {
        HeavenlyBody heavenlyBody;
        switch (bodyType) {
            case "planet" -> {
                heavenlyBody = new Planet(name, bodyType, orbitalPeriod);
                planets.add(heavenlyBody);
            }
            case "dwarf planet" -> {
                heavenlyBody = new DwarfPlanet(name, bodyType, orbitalPeriod);
                dwarfPlanets.add(heavenlyBody);
            }
            case "moon" -> {
                heavenlyBody = new Moon(name, bodyType, orbitalPeriod);
                moons.add(heavenlyBody);
                if (!orbitalParent.isBlank()) {
                    solarSystem.get(orbitalParent).addMoon(heavenlyBody);
                }
            }
            default -> heavenlyBody = new HeavenlyBody(name, bodyType, orbitalPeriod);
        };
        if (solarSystem.containsKey(heavenlyBody.getName())) {
            System.out.println("triggered");
            if (solarSystem.get(heavenlyBody.getName()).equals(heavenlyBody)) {
                System.out.println("A " + heavenlyBody.getBodyType() + " named " + heavenlyBody.getName() + " already exists");
                return;
            }
        }
        solarSystem.put(heavenlyBody.getName(), heavenlyBody);
    }
}
