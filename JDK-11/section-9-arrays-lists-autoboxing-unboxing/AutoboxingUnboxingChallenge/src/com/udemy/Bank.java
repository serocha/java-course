package com.udemy;

import java.util.ArrayList;

/*
*   The Bank class represents a common interface to handle accounts and process transactions
*   This class got bigger than I expected
*   Offloaded interface functionality to App() class
*/

public class Bank {
    private final String bankName;
    private final ArrayList<Branch> branchList;

    public Bank(String bankName) {
        this(bankName, new ArrayList<>());
    }

    public Bank(String bankName, ArrayList<Branch> branchList) {
        this.bankName = bankName;
        this.branchList = branchList;

        if (this.branchList.isEmpty()) {
            branchList.add(new Branch("Main"));
        }
    }

    protected String getBankName() {
        return bankName;
    }

    protected ArrayList<Branch> getBranchList() {
        return branchList;
    }

    protected void addCustomer(String customerName, double initialDeposit, String branchName) {
        Branch branch = getBranch(branchName);
        branch.addCustomer(customerName, initialDeposit);
    }

    protected void deleteCustomer(String customerName) {
        Branch branch = getCustomerBranch(customerName);
        branch.deleteCustomer(customerName);
    }

    /*protected void deposit(String customerName, double depositAmount) {
        Customer customer = getCustomer(customerName);
        customer.deposit(depositAmount);
    }

    protected void withdrawal(String customerName, double withdrawalAmount) {
        Customer customer = getCustomer(customerName);
        customer.withdrawal(withdrawalAmount);
    }

    protected String printStatement(String customerName) {
        Customer customer = getCustomer(customerName);
        return customer.printTransactions();
    }*/

    protected void addBranch(String branchName) {
        Branch branch = new Branch(branchName);
        branchList.add(branch);
    }

    protected String getAllBranches() {
        StringBuilder branches = new StringBuilder();
        for (Branch branch : branchList) {
            branches.append(String.format("%s%n", branch.getBranchName()));
        }
        return branches.toString();
    }

    protected boolean isBranch(String branchName) {
        for (Branch branch : branchList) {
            if (branch.getBranchName().equals(branchName)){
                return true;
            }
        }
        return false;
    }

    protected boolean isCustomer(String customerName) {
        for (Branch branch : branchList) {
            if (branch.isCustomer(customerName)) {
                return true;
            }
        }
        return false;
    }

    protected Branch getBranch(String branchName) {
        for (Branch branch : branchList) {
            if (branch.getBranchName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }

    protected Customer getCustomer(String customerName) {
        for (Branch branch : branchList) {
            Customer customer = branch.getCustomer(customerName);
            if (customer != null) {
                return customer;
            }
        }
        return null;
    }

    protected Branch getCustomerBranch(String customerName) {
        for (Branch branch : branchList) {
            if (branch.isCustomer(customerName)) {
                return branch;
            }
        }
        return null;
    }
}
