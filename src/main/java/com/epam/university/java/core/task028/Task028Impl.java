package com.epam.university.java.core.task028;

import java.util.stream.Stream;

/**
 * Created by ilya on 03.10.17.
 */
public class Task028Impl implements Task028 {

    private int varCounter;
    private int[] powers;
    private int length;

    @Override
    public int getWays(int value, int power) {
        int max = (int) Math.pow(value, 1.0 / (double) power);

        final int[] powers = Stream
            .iterate(1, n -> n + 1)
            .limit(max)
            .map(n -> (int) Math.pow(n, power))
            .mapToInt(n -> n).toArray();

        this.powers = powers;
        length = powers.length;
        recursionFind(length - 1, value);

        return varCounter;
    }

    private void recursionFind(int counter, int difference) {
        if (difference < 0) {
            return;
        }
        if (counter < 0) {
            if (difference == 0) {
                varCounter++;
            }
            return;
        }

        recursionFind(counter - 1, difference);
        recursionFind(counter - 1, difference - powers[counter]);

    }

}
