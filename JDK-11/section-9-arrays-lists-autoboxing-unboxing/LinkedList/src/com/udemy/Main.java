package com.udemy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer("Joe", 54.96);
        Customer anotherCustomer; // new instance
        anotherCustomer = customer; // assign address to point to first
        anotherCustomer.setBalance(12.18); // same pointer

        printBalance(customer);
        printBalance(anotherCustomer);

        ArrayList<Integer> intList = new ArrayList<>(); // ArrayList<Integer>() also valid, but redundant
        intList.add(9);
        intList.add(5);
        intList.add(13);
        intList.add(10);

        for (int i=0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
        System.out.println();
        intList.add(1,2); // each subsequent element must be shifted

        for (int i=0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
        // inefficient, thus why LinkedLists exist
    }

    public static void printBalance (Customer customer) {
        System.out.println("Balance for " + customer.getName() + " is " + customer.getBalance());
    }
}
