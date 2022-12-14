package com.udemy;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        // key/value pairs, keys are unique
        Map<String, String> languages = new HashMap<>();
        languages.put("Java", "A compiled high-level, object-oriented, platform independent language");
        languages.put("Python", "An interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "An algorithmic language");
        // a .put() call returns whether or not the key is a new key or is being reused
        System.out.println(languages.put("BASIC", "Beginners All-purpose Symbolic Instruction Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "You're learning about maps");
        }
        // reusing a key overwrites the old value
        System.out.println(languages.put("Java", "This course is about Java")); // .put() returns old value
        System.out.println(languages.get("Java"));

        System.out.println("=======================================================");

        //languages.remove("Lisp"); // remove by key
        if (languages.remove("Algol", "A family of algorithmic languages")) {
            // remove by key/value pairs, also returns a boolean
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        if(languages.replace("Lisp", "Therein lies madness", "A functional programming language with imperative features")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp not replaced");
        }
        //System.out.println(languages.replace("Scala", "This will not be added"));
        // sets will be covered later
        for (String key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
