package com.udemy;

import java.util.Scanner;

// sort an int array of user input in descending order
public class Main {
    public static final int NUMBER_OF_INTEGERS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = getIntegers(scanner);
        printIntegers(sortIntegers(array));
    }

    public static int[] getIntegers(Scanner scanner) {
        int[] intArray = new int[NUMBER_OF_INTEGERS];

        System.out.printf("Please enter a series of %d integers.%n", intArray.length);

        for(int i = 0; i < intArray.length; i++) {
            System.out.printf("Int %d: ", i+1);
            intArray[i] = scanner.nextInt();
        }
        scanner.reset();
        return intArray;
    }

    public static void printIntegers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = array;

        /*for (int i=0; i<array.length; i++) {
            if (i == 0) {
                for (int j=0; j<array.length; j++) {
                    if (sortedArray[0] < array[j]) {
                        sortedArray[0] = array[j];
                    }
                }
            } else {
                for (int j=0; j<array.length; j++) {
                    if (array[j] > sortedArray[i] && array[j] < sortedArray[i-1]) {
                        sortedArray[i] = array[j];
                    }
                }
            }
        }*/
        int temp;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i=0; i<sortedArray.length-1; i++) {
                if (sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
}
