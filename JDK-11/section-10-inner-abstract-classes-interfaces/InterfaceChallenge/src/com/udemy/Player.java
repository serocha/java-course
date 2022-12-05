package com.udemy;

import java.util.ArrayList;
import java.util.List;

public class Player implements ISaveable {

    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player (String name, int hitPoints, int strength) {
        this.name = name;
        weapon = "Sword";
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    @Override
    public void read(List<String> data) {
        if (data != null && data.size() > 0) {
            name = data.get(0);
            hitPoints = Integer.parseInt(data.get(1));
            strength = Integer.parseInt(data.get(2));
            weapon = data.get(3);
        }
    }

    @Override
    public List<String> write() {
        List<String> data = new ArrayList<>();
        // can omit index, but here for specificity
        data.add(0, name);
        data.add(1, String.valueOf(hitPoints)); // can also concat to empty string
        data.add(2, String.valueOf(strength));
        data.add(3, weapon);
        return data;
    }

    @Override
    public String toString() {
        return "Player{name='" + name + "', " +
                "hitPoints=" + hitPoints + ", " +
                "strength=" + strength + ", " +
                "weapon='" + weapon + "'}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
