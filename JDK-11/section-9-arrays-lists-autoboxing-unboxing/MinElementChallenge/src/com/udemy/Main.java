package com.udemy;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static final int COUNT = 5; // how many integers to ask for

    public static void main(String[] args) {
        System.out.printf("Please enter %d integers.%n", COUNT);
        int[] array = readIntegers(COUNT);
        int min = findMin(array);
        scanner.reset();
    }

    public static int[] readIntegers(int count) {
        int[] array = new int[count];
        for (int i=0; i<array.length; i++) {
            System.out.printf("Element %d = ", i+1);
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int findMin(int[] array) {
        int temp = array[0];

        for (int i=0; i<array.length; i++) {
            if (array[i] < temp) {
                temp = array[i];
            }
        }
        System.out.println("The minimum value in the array is " + temp);
        return temp;
    }
}
