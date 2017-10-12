package com.epam.university.java.core.task028;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task028Impl implements Task028 {
    Set<TreeSet> resultSet = new HashSet<>();

    @Override
    public int getWays(int value, int power) {
        calculateWays(value, power, new TreeSet<Integer>());
        return resultSet.size();
    }

    public void calculateWays(int value, int power, TreeSet<Integer> used) {
        if (value == 0) {
            resultSet.add(used);
        }
        if (value > 0) {
            int root = (int) Math.pow(value, 1.0 / power);
            for (int i = root; i > 0; i--) {
                if (!used.contains(i)) {
                    TreeSet<Integer> destUsed = new TreeSet<>(used);
                    destUsed.add(i);
                    calculateWays(value - (int) Math.pow(i, power), power, destUsed);
                }
            }
        }
    }

}
