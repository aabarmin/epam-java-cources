package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {

    @Override
    public int getWays(int value, int power) {
        return getWays(0, value, 1, power, 0);
    }

    private int getWays(int sum, int value, int current, int power, int ways) {
        if (sum == value) {
            return 1;
        }
        int result = ways;
        for (int i = current; sum + (int) Math.pow(i, power) <= value; ++i) {
            result += getWays(
                    sum + (int) Math.pow(i, power),
                    value,
                    i + 1,
                    power,
                    ways
            );
        }
        return result;
    }

}