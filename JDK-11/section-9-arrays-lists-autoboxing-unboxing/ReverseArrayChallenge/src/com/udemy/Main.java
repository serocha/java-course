package com.udemy;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        reverse(array);
        System.out.println();
        int[] secondArr = {91, 23, 55, 2, -1, 8, 5, 70};
        reverse(secondArr);
    }

    private static void reverse(int[] array) {
        System.out.println("Original: " + Arrays.toString(array));
        int temp;
        // swap elements sequentially, meaning you only have to go halfway
        for (int i=0; i<array.length/2; i++) {
            temp = array[i];
            array[i] = array[(array.length-1)-i];
            array[(array.length-1)-i] = temp;
        }
        System.out.println("Reversed: "+ Arrays.toString(array));
    }
}
