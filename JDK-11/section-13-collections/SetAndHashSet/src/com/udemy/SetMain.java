package com.udemy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    // a class to hold a main() method
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i<=100; i++) {
            squares.add(i*i);
            cubes.add(i*i*i);
        }
        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");

        // note that nearly all Collection classes have constructors that take another Collection for values
        // bulk operations on sets (.addAll() .removeAll() etc) are destructive,
        // so they modify the Set they're called upon. Don't perform on the original Set
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements");
        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "One day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        for (String s : words) {
            System.out.println(s);
        }

        // asymmetric difference; set 2 takes set 1 != set 1 takes set 2
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "is", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        // remove shared elements, leaving asymmetric results
        System.out.println("nature - divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        // java has no method for taking symmetric difference
        // can calculate by taking the union - intersection
        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);
        System.out.println();
        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        // containsAll() is non-destructive -> boolean
        if (nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("Intersection is a subset of nature");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("Intersection is a subset of divine");
        }
    }

    private static void printSet(Set<String> set) {
        for(String string : set) {
            System.out.println(string);
        }
    }
}
