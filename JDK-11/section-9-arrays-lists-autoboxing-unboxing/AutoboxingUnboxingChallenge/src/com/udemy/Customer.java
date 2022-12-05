package com.udemy;

import java.text.NumberFormat;
import java.util.ArrayList;

/*
*   The only validation handled in Customer is if the withdrawal exceeds the balance
*/
public class Customer {

    private final String customerName;
    private double balance;
    private final ArrayList<Double> transactionList;

    protected Customer(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
        transactionList = new ArrayList<>();
        transactionList.add(balance); // implicit boxing
    }

    protected String getCustomerName() {
        return customerName;
    }

    protected double getBalance() {
        return balance;
    }

    protected void deposit(double depositAmount) {
        balance += depositAmount;
        transactionList.add(depositAmount); // record transaction (autoboxing)
    }

    protected void withdrawal(double withdrawalAmount) {
        balance -= withdrawalAmount;
        transactionList.add(-withdrawalAmount); // reverse to signify withdrawal (autoboxing)
    }

    protected String printTransactions() {
        // don't expose the ArrayList, just format the data and return that
        StringBuilder transactions = new StringBuilder();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        transactions.append("Transaction Record:\n");
        for (double transaction : transactionList) {
            String formattedTransaction = String.format("%s%n",nf.format(transaction));
            transactions.append(formattedTransaction);
        }
        transactions.append(String.format("%s%n%s","Current Balance:",nf.format(balance)));

        return transactions.toString();
    }
}
