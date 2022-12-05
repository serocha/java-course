package com.udemy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String[] strArray = new String[10];
        int[] intArray = new int[10];
        ArrayList<String> strArrayList= new ArrayList<String>();

        strArrayList.add("Joe");

        // as primitive types aren't objects, you have to give them a wrapper class to work with
        Integer integer = new Integer(1);

        // long form
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            // convert base integer into the Integer object wrapper
            intArrayList.add(Integer.valueOf(i)); // boxing
        }
        for (int i=0; i<10; i++) {
            // convert object wrapper back to primitive type
            System.out.println(i + " -> " + intArrayList.get(i).intValue()); // unboxing
        }

        Integer myIntValue = 56; // Integer.valueOf(56); <-- at compile time; no constructor needed
        int myInt = myIntValue; // myIntValue.intValue(); <-- return the int from object

        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for (double dbl=0.0; dbl<=10.0; dbl+=0.5) {
            myDoubleValues.add(Double.valueOf(dbl)); // again, you can omit the Double.valueOf()
        }

        for (int i=0; i<myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i).doubleValue();
            System.out.println(i + " --> " + value);
        }
    }
}
