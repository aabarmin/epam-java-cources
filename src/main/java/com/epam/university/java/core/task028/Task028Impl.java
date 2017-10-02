package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    private int result = 0;
    
    @Override
    public int getWays(int value, int power) {
        countWaysRecursive(value, value, 0, power);
        return result;
    }
    
    private void countWaysRecursive(int value, int diff, int tryNumber, int power) {
        // if diff = 0 - we found another one solution
        if (diff == 0) {
            result++;
        }
        
        // looping to the
        int countTo = (int) Math.floor(
                Math.pow(value, 1.0 / power)
        );

        // recursive calling to find other numbers
        for (int i = tryNumber + 1; i <= countTo; i++) {
            int newDiff = diff - (int) Math.pow(i, power);
            if (newDiff >= 0) {
                countWaysRecursive(value, newDiff, i, power);
            }
        }
    }
}
