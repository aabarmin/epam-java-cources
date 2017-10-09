package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    private int result = 0;

    @Override
    public int getWays(int value, int power) {
        recurentFind(value, value, power, 0);
        return result;
    }

    private void recurentFind(int value, int
            remain, int power, int checkNum) {
        if (remain == 0) {
            result++;
        }
        int biggestPowInNum = (int) Math.floor(Math.pow(value, 1.0 / power));

        for (int i = checkNum + 1; i <= biggestPowInNum; i++) {
            int newRemain = remain - (int) Math.pow(i, power);
            if (newRemain >= 0) {
                recurentFind(value, newRemain, power, i);
            }
        }
    }
}
