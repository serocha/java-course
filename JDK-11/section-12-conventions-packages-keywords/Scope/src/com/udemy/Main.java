package com.udemy;

public class Main {

    public static void main(String[] args) {
        String varFour = "I'm varFour, a variable private to main()"; // available anywhere in main()
        String publicVar = "I'm publicVar, a variable private to main()";
        System.out.println();

        ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println(varFour);
        System.out.println(publicVar); // this is the only publicVar in scope, even though scopeCheck has publicVar

        // scopeCheck.publicVar is within scope but scopeCheck.varOne is outside of current scope
        System.out.println("scopeCheck publicVar = " + scopeCheck.publicVar);
        System.out.println("scopeCheck varOne = " + scopeCheck.getVarOne());
        System.out.println("scopeCheck.timesTwo() has a local varThree: ");
        scopeCheck.timesTwo();
        System.out.println("scopeCheck varOne = " + scopeCheck.getVarOne());

        // scopeCheck can access the private var within InnerClass as it has a getter
        scopeCheck.useInner();
        // ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass();
        // innerClass.varThree;  <--  but trying to do it this way is inaccessible (unless it's made public)

        System.out.println("**********************************");
        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass(); // remember the syntax of inner classes
        innerClass.timesTwo();
    }
}
