package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    private int result = 0;

    @Override
    public int getWays(int value, int power) {
        // recursion should loop to the
        int countTo = (int) Math.floor(
                Math.pow(value, 1.0 / power)
        );
        
        // count ways
        countWaysRecursive(value, 0, power, countTo);
        return result;
    }

    private void countWaysRecursive(int diff, int tryNumber, int power, int countTo) {
        // if diff = 0 - we found another one solution
        if (diff == 0) {
            result++;
            return;
        }

        // recursive calling to find other numbers
        for (int i = ++tryNumber; i <= countTo; i++) {
            int newDiff = diff - (int) Math.pow(i, power);
            if (newDiff >= 0) {
                countWaysRecursive(newDiff, i, power, countTo);
            } else {
                return;
            }
        }
    }
}
