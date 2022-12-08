package com.udemy;

public class Main {

    public static void main(String[] args) {

        // when you expose fields of classes, then anyone could assume that's intentional
        // other classes might then alter them directly, which bypasses any methods intended
        // for handling validation or proper manipulation
        Account account = new Account("Bob");
        account.deposit(1000);
        account.withdraw(500);
        account.withdraw(-200);
        account.deposit(-20);
        account.calculateBalance();
        System.out.println("Balance on account " + account.getBalance());
        //account.balance = 5000; // whoops
        //account.transactions.add(5000); // fraud!
    }
}
