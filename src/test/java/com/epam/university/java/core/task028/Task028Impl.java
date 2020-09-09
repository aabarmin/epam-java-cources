package com.epam.university.java.core.task028;

/**
 * Author Dmitry Novikov 07-Sep-20.
 */
public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return checkRecursive(value, power, 1, 0);
    }

    static int power(int num, int n) {
        if (n == 0) {
            return 1;
        } else if (n % 2 == 0) {
            return power(num, n / 2) * power(num, n / 2);
        } else {
            return num * power(num, n / 2) * power(num, n / 2);
        }

    }

    static int checkRecursive(int x, int n, int currNum, int currSum) {
        int results = 0;

        int p = power(currNum, n);
        while (p + currSum < x) {
            results += checkRecursive(x, n, currNum + 1,
                    p + currSum);
            currNum++;
            p = power(currNum, n);
        }

        // If sum of powers is equal to x
        // then increase the value of result.
        if (p + currSum == x) {
            results++;
        }


        // Return the final result
        return results;
    }
}
