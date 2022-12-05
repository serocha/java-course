package com.udemy;

import java.util.ArrayList;

/*
*   Note that validation should be handled by the bank class
*   The validation functions here are designed to be accessed by the bank validation functions
*/
public class Branch {

    private final String branchName;
    private final ArrayList<Customer> customerList;

    protected Branch(String branchName) {
        this(branchName, new ArrayList<>());
    }

    protected Branch(String branchName, ArrayList<Customer> customerList) {
        this.branchName = branchName;
        this.customerList = customerList;
    }

    protected String getBranchName() {
        return branchName;
    }

    protected String getAccountList() {
        StringBuilder accountList = new StringBuilder();
        for (Customer customer : customerList) {
            accountList.append(String.format("%s%n", customer.getCustomerName()));
        }
        return accountList.toString();
    }

    protected ArrayList<Customer> getCustomerList() {
        return customerList;
    }

    protected Customer getCustomer(String customerName) {
        if (isCustomer(customerName)) {
            return customerList.get(getCustomerIndex(customerName));
        } else {
            return null;
        }
    }

    protected void addCustomer(String customerName, double initialDeposit) {
        Customer customer = new Customer(customerName, initialDeposit);
        customerList.add(customer);
    }

//    protected void addCustomer(Customer customer) {
//        customerList.add(customer);
//    }

    protected void deleteCustomer(String customerName) {
        customerList.remove(getCustomerIndex(customerName));
    }

//    protected void deposit(Customer customer, double depositAmount) {
//        customer.deposit(depositAmount);
//    }
//
//    protected void withdrawal(Customer customer, double withdrawalAmount) {
//        customer.withdrawal(withdrawalAmount);
//    }

    protected int getCustomerIndex(String customerName) {
        if (isCustomer(customerName)) {
            for (Customer customer : customerList) {
                if (customer.getCustomerName().equals(customerName)) {
                    return customerList.indexOf(customer);
                }
            }
        }
        return -1;
    }

    protected boolean isCustomer(String customerName) {
        for (Customer existingCustomer : customerList) {
            if (existingCustomer.getCustomerName().equals(customerName)) {
                return true;
            }
        }
        return false;
    }
}
