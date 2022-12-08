package com.udemy.math;

public class Series {

    public static int nSum(int n) {
        int sum = 0;
        for (int i=0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long factorial(int n) {
        if (n == 0) {
            return 0;
        }

        long factorial = 1L;
        for (long i=2; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else {
            int l = 1;
            for (int i = 1; i <= n; i++) {
                l = fibonacci(i - 2) + fibonacci(i - 1);
            }
            return l;
        }
    }
}
