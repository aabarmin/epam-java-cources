package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return checkRecursive(value, power, 1, 0);
    }

    private int checkRecursive(int value, int power, int curNum, int curSum) {
        int results = 0;
        //Calling power of 'curNum' raised to 'power'
        int numPow = pow(curNum, power);
        while (numPow + curSum < value) {
            // Recursively check all greater values of 'curNum'
            results += checkRecursive(value, power, curNum + 1, numPow + curSum);
            curNum++;
            numPow = pow(curNum, power);
        }
        if (numPow + curSum == value) {
            results++;
        }
        return results;
    }

    // Calculates the power of given number
    private int pow(int curNum, int pow) {
        if (pow == 0) {
            return 1;
        } else if (pow % 2 == 0) {
            return pow(curNum, pow / 2) * pow(curNum, pow / 2);
        } else {
            return curNum * pow(curNum, pow / 2) * pow(curNum, pow / 2);
        }
    }
}