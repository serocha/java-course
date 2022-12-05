package com.udemy;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName) == null) {
            customers.add(new Customer(customerName, initialTransaction));
            return true;
        } else {
            return false;
        }
    }

    public boolean addCustomerTransaction(String customerName, double transaction) {
        if (findCustomer(customerName) != null) {
            int index = customers.indexOf(findCustomer(customerName));
            customers.get(index).addTransaction(transaction);
            return true;
        } else {
            return false;
        }
    }

    private Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customer.getName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }
}
