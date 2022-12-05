package com.udemy;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in); // note the use of a static variable -> not an instance
    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5);

        printArray(myIntegers);
        System.out.printf("The average of the values in the array is %f%n",getAverage(myIntegers));
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values. \r"); // carriage return
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt(); // carriage return is needed because nextInt() doesn't insert a new line
        }
        return values;
    }

    public static void printArray(int[] array) {
        // note that you have to define the type and tell it to expect an array with []
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Element %d, value is %d%n", i, array[i]);
        }
    }

    public static double getAverage(int[] array) {
        // returns a double because averages may not be whole
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (double) sum / array.length;
    }
}
/*
    //int[] myIntArray = new int[10];
    //myIntArray[5] = 50;
    //myIntArray[0] = 10;
    int[] myIntArray = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(myIntArray[5]);
                System.out.println(myIntArray[9]);
                System.out.println(myIntArray[0]);

                double[] myDoubleArray = new double[10];
                for (int i = 0; i < myDoubleArray.length; i++) {
        myDoubleArray[i] = i*10;
        }

        printArray(myDoubleArray);
        }
*/
