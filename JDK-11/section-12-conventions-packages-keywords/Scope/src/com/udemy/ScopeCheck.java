package com.udemy;

public class ScopeCheck {

    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck() created, publicVar = " + publicVar + ", varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {

        // this is a local instance of privateVar separate from this.privateVar
        int varTwo = 2; // if you comment this out, Java will detect the member variable instead of the local
        for (int i=0; i<10; i++) {
            System.out.println(i + " time two is " + i * varTwo);
        }
        System.out.println("ScopeCheck.timesTwo() varTwo = " + varTwo);
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
    }

    public class InnerClass {
        private int varThree = 3; // this will be used in timesTwo()

        public InnerClass() {
            System.out.println("InnerClass created, varOne = " + varOne + " and varThree = " + varThree);
        }

        public void timesTwo() {
            // this time we're not defining a local privateVar
            System.out.println("varOne is still available here in InnerClass.timesTwo() = " + varOne);
            for (int i=0; i<10; i++) {
                System.out.println(i + " time two is " + i * varThree);
            }
            System.out.println("timesTwo() varThree = " + varThree);
        }
    }
}
