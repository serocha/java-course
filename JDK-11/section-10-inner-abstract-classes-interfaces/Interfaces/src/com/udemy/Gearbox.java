package com.udemy;

public class Gearbox {

    private boolean clutchIsIn;

    public void operateClutch(boolean inOrOut) {
        this.clutchIsIn = inOrOut;
        // if you later decide to change the param or return of operateClutch(), it can cause all
        // sorts of issues with any other classes that might be using the method
    }
}
