package com.epam.university.java.core.task028;

import edu.princeton.cs.introcs.In;

import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class Task028Impl implements Task028 {
    @Override
    public int getWays(int value, int power) {
        return getWaysRecRoutine(0, value, 1, power, 0);
    }

    private int getWaysRecRoutine(int sum, int target, int currentNum, int power, int ways) {
        if (sum == target) {
            return 1;
        }
        int localWays = ways;
        for (int num = currentNum; sum + (int) Math.pow(num, power) <= target; ++num) {
            localWays += getWaysRecRoutine(
                    sum + (int) Math.pow(num, power),
                    target,
                    num + 1,
                    power,
                    ways
            );
        }
        return localWays;
    }

}



