package com.udemy;

import java.util.Scanner;

public class X {
    int x;
    public X() {
        super();
    }

    public void x() {
        System.out.print("Please enter an integer: ");
        this.x = new Scanner(System.in).nextInt();
        int x = 1;
        while (true) {
            System.out.println(this.x + " times " + x + " equals " + this.x * x);
            x++;
            if (x > 12) {
                break;
            }
        }
    }

    // alternative version
    // public void x() {
    //      for (int x=0; x<13; x++) {
    //          System.out.println(this.x + " times " + x + " equals " + this.x * x);
    //      }
    // }
    // in this case you have to set the Scanner as part of the constructor: X(Scanner x) {this.x = x.nextInt();}
}
