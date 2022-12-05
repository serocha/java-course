package com.udemy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int firstIntValue = 10; // firstIntValue is a value
        int secondIntValue = firstIntValue;

        System.out.println("firstIntValue = " + firstIntValue + "\nsecondIntValue = " + secondIntValue);
        secondIntValue++;
        System.out.println("firstIntValue = " + firstIntValue + "\nsecondIntValue = " + secondIntValue);
        // as secondIntValue is not a reference to firstIntValue

        int[] firstArray = new int[5]; // firstArray is a reference
        int[] secondArray = firstArray; // secondArray points to the same reference
        // you'd need to instantiate using the new keyword to make another array
        System.out.println("firstArray = " + Arrays.toString(firstArray) +
                "\nsecondArray = " + Arrays.toString(secondArray));
        secondArray[0] = 1;
        firstArray[1] = -1;
        System.out.println("firstArray = " + Arrays.toString(firstArray) +
                "\nsecondArray = " + Arrays.toString(secondArray));
        // both firstArray and secondArray point to the same object in memory

        secondArray = modifyArray(firstArray); // return a new array
        System.out.println("firstArray = " + Arrays.toString(firstArray) +
                "\nsecondArray = " + Arrays.toString(secondArray));
    }

    private static int[] modifyArray(int[] array) {
        array[0] = 2; // modify the object referenced
        array = new int[] {1, 2, 3, 4, 5}; // object is dereferenced because of the new keyword
        return array; // returns a new array in memory
    }
}
