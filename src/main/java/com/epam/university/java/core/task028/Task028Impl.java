package com.epam.university.java.core.task028;


import java.util.ArrayList;
import java.util.Collections;

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
        for (int i = 1, n = 1; n <= value; n = getPower(++i, power) ) {
            uniques.add(n);
        }
        Collections.reverse(uniques);
        Integer[] powers = uniques.toArray(new Integer[uniques.size()]);

        return wayCount(value, powers, 0);
    }

    // counter
    private int wayCount(int destination, Integer[] powers, int index) {

        int result = 0;
        if( destination == powers[index] ) {
            result++;
        } else {
            destination -= powers[index];
        }

        for (int i = index + 1; i < powers.length; i++) {
            if (destination < 0) {
                continue;
            }
            result += wayCount(destination, powers, i);
        }

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
