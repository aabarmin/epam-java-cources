package com.epam.university.java.core.task028;


import java.util.ArrayList;
import java.util.Collection;

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
        Collection<Integer> uniques = new ArrayList<>();
        int entry = 1;
        for (int i = 1; entry < value; i++ ) {
            uniques.add(i);
            entry = power(i, power);
        }

        return 0;
    }



    // power of int value
    private int power(int value, int power) {

        int ret = value;
        for (int i = 1; i < power; i++) {
            ret *= value;
        }
        return ret;
    }
}
