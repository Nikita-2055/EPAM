package com.epam.rd.autotasks;


class LoopStatements {
    public static int sumOfFibonacciNumbers(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Value n should be positive");
        }

        int a = 1;
        int b = 1;
        int sum = 0;

        for (int i = 1; i <= n; i++) {

            if (i == 1 || i == 2) {
                sum += 1;
            } else {
                int next = a + b;
                sum += next;
                a = b;
                b = next;
            }
        }

        return sum;
    }

}
