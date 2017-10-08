package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        int limit = (int) Math.pow(value, 1.0/power);
        return 0;
    }
}
