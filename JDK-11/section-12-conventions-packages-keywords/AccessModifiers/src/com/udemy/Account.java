package com.udemy;

import java.util.ArrayList;

public class Account {
    // demonstration of what can happen by declaring member vars as public, switched to private

    private String accountName;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String accountName) {
        this.accountName = accountName;
        this.transactions = new ArrayList<>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance is now " + this.balance);
        } else {
            System.out.println("Can't deposit a negative sum");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            transactions.add(-amount);
            this.balance -= amount;
            System.out.println(amount + " withdrawn. Balance is now " + this.balance);
        } else {
            System.out.println("Can't withdraw a negative sum");
        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for (int i : this.transactions) {
            this.balance += i; // use transaction list to calculate the balance
        }
        System.out.println("Calculated balance is " + this.balance);
    }
}
