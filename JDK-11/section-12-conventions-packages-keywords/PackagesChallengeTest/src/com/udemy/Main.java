package com.udemy;

import com.udemy.math.Series;

// quick demo of a custom package math.Series and the associated functions
public class Main {

    public static void main(String[] args) {

        for (int i=0; i<=10; i++) {
            System.out.println("Fibonacci(" + i + ") = " + Series.fibonacci(i));
        }
        System.out.println();
        for (int i=0; i<=10; i++) {
            System.out.println("Factorial(" + i + ") = " + Series.factorial(i));
        }
        System.out.println();
        for (int i=0; i<=10; i++) {
            System.out.println("nSum(" + i + ") = " + Series.nSum(i));
        }
    }
}
