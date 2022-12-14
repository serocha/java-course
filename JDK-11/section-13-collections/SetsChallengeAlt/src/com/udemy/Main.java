package com.udemy;

public class Main {
    public static void main(String[] args) {

        Planet earth = new Planet("Earth", 365);
        Moon moon = new Moon("Moon", 28);

        earth.addSatellite(moon);
    }
}
