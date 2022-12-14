package com.udemy;

import java.util.HashSet;
import java.util.Set;

/*      An incomplete attempt at solving the project as presented
 *      The only solution I haven't found is how to structure the Map that holds the bodies
 *      such that they can possess the same name but have different bodyTypes
 *
 *      One solution I've played with is creating a key class which can store both name and
 *      bodyType, but I'm not sure how best to implement it
 *      Will do the predefined challenge for now and possibly revisit this
 */
public class Main {

    public static enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON;
    }
    public static void main(String[] args) {

        SolarSystem sol = new SolarSystem();
        sol.createHeavenlyBody("Mercury", "planet", 88);
        sol.createHeavenlyBody("Venus", "planet", 225);
        sol.createHeavenlyBody("Earth", "planet", 365);
        sol.createHeavenlyBody("Moon", "moon", 27, "Earth");
        sol.createHeavenlyBody("Mars", "planet", 687);
        sol.createHeavenlyBody("Deimos", "moon", 1.3, "Mars");
        sol.createHeavenlyBody("Phobos", "moon", 0.3, "Mars");
        sol.createHeavenlyBody("Jupiter", "planet", 4332);
        sol.createHeavenlyBody("Io", "moon", 1.8, "Jupiter");
        sol.createHeavenlyBody("Europa", "moon", 3.5, "Jupiter");
        sol.createHeavenlyBody("Ganymede", "moon", 7.1, "Jupiter");
        sol.createHeavenlyBody("Callisto", "moon", 16.7, "Jupiter");
        sol.createHeavenlyBody("Saturn", "planet", 10759);
        sol.createHeavenlyBody("Uranus", "planet", 30660);
        sol.createHeavenlyBody("Neptune", "planet", 165);
        sol.createHeavenlyBody("Pluto", "dwarf planet", 248);

        System.out.println("Planets");
        for(HeavenlyBody planet : sol.getPlanets()) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody body = sol.getSolarSystem().get("Jupiter");
        System.out.println("Moons of " + body.getName());
        for (HeavenlyBody moon : body.getSatellites()) {
            System.out.println("\t" + moon.getName());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for (HeavenlyBody planet : sol.getPlanets()) {
            moons.addAll(planet.getSatellites());
        }

        System.out.println("All Moons");
        for (HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getName());
        }

        // add another element with the same name but different Set parameters
        // the two objects DO NOT compare equal, so for custom objects you must override the equals() and hashcode()
        System.out.println("\nAttempt to add a second Earth with different orbital period");
        sol.createHeavenlyBody("Earth", "moon", 842);
        for (String s : sol.getSolarSystem().keySet()) {
            System.out.println(sol.getSolarSystem().get(s).getName() + ": " + sol.getSolarSystem().get(s).getOrbitalPeriod());
        }
    }
}
