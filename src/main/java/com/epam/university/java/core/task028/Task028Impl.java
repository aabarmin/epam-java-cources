package com.epam.university.java.core.task028;

import java.util.stream.IntStream;

public class Task028Impl implements Task028 {

    @Override
    public int getWays(int value, int power) {
        final int lim = (int) Math.floor(Math.pow(value, 1.0 / power));

        int[] possiblePowers = IntStream
                .range(1, lim + 1)
                .map(s -> (int) Math.pow(s, power))
                .toArray();

        return recurrentFind(value, possiblePowers, 0);
    }

    private int recurrentFind(int remain, int[] possiblePowers, int i) {

        if (i >= possiblePowers.length
                || remain < possiblePowers[i]) {
            return 0;
        }

        if (remain == possiblePowers[i]) {
            return 1;
        }

        int result = 0;

        result += recurrentFind(remain, possiblePowers, i + 1);

        result += recurrentFind(remain - possiblePowers[i],
                possiblePowers, i + 1);

        return result;
    }
}
