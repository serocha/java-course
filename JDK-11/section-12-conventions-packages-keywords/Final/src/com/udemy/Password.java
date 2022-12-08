package com.udemy;

public class Password {
    private static final int key = 574396912;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password);
    }

    private int encryptDecrypt(int password) {
        // XOR operator is a bitwise operator that takes two booleans and return true if operands are different
        // can be used on all primitives; bitwise -> compares matching bits of two values, bit by bit (returns binary)
        return password ^ key;
    }

    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if (encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Go away");
            return false;
        }
    }
}
