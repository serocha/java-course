package com.udemy;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;

        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            branches.add(new Branch(branchName));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean printTransactions) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            System.out.println("Customer details for branch " + branchName);
            ArrayList<Customer> customers = branch.getCustomers();
            for (int i=0; i<customers.size(); i++) {
                ArrayList<Double> transactions = customers.get(i).getTransactions();
                System.out.println("Customer: " + customers.get(i).getName() +
                        "[" + (i+1) + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    for (int j=0; j<transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "]  Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        return false;
    }
}

