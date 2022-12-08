package com.udemy;

/*  CHALLENGE
 *  What is the visibility of:
 *  1. the Accessible interface?
 *  2. the int variable SOME_CONSTANT
 *  3. methodA?
 *  4. methodB and methodC?
 */
interface Accessible {          // package-private
    int SOME_CONSTANT = 100;    // public; all interface vars are public static final
    public void methodA();      // public (redundant)
    void methodB();             // public (auto)
    boolean methodC();          // public
}
