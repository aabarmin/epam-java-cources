package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return waysCount(value, power, 1);
    }

    private int waysCount(int value, int power, int start) {
        int delta = (int) (value - Math.pow(start, power));
        if (delta == 0) {
            return 1;
        }
        if (delta < 0) {
            return 0;
        }
        return waysCount(value, power, start + 1) + waysCount(delta, power, start + 1);
    }
}
