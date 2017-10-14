package com.epam.university.java.core.task028;


import java.util.ArrayList;

/**
 * Implementation class for Task028.
 *
 * @author Sergei Titov
 */
public class Task028Impl implements Task028 {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWays(int value, int power) {

        // collection of unique powers
        ArrayList<Integer> uniques = new ArrayList<>();
        for (int i = 1, n = 1; n <= value; n = getPower(++i, power)) {
            uniques.add(n);
        }

        Integer[] powers = uniques.toArray(new Integer[uniques.size()]);

        return wayCount(value, powers, 0);
    }

    /**
     * Recursive counting method.
     *
     * @param destination - sum of powers we are trying to compose.
     * @param powers - array of powers to compose from.
     * @param index - position in "powers" we are starting from
     *
     * @return a number of possible compositions
     */
    private int wayCount(int destination, Integer[] powers, int index) {

        if (index >= powers.length
                || destination < powers[index]) {
            return 0;
        }

        if (destination == powers[index]) {
            return 1;
        }

        int result = 0;

        // without
        result += wayCount(destination, powers, index + 1);

        // within
        result += wayCount(destination - powers[index], powers, index + 1);


        return result;
    }

    // power of int value
    private int getPower(int value, int power) {

        int ret = value;
        for (int i = 1; i < power; i++) {
            ret *= value;
        }
        return ret;
    }
}