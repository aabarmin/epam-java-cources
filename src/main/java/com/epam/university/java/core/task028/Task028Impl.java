package com.epam.university.java.core.task028;


public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return countWays(value, power);
    }

    int countWays(int x, int n) {
        return countWaysUtil(x, n, 1);
    }

    int countWaysUtil(int x, int n, int num) {
        int val = (int) (x - Math.pow(num, n));
        if (val == 0) {
            return 1;
        }
        if (val < 0) {
            return 0;
        }

        return countWaysUtil(val, n, num + 1)
                +
                countWaysUtil(x, n, num + 1);
    }
}
