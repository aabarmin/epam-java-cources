package com.epam.university.java.core.task028;

/**
 * {@inheritDoc}
 */
public class Task028Impl implements Task028 {

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWays(int value, int power) {
        return findByRecursion(value, power, 0);
    }


    /**
     * Method finds the number of ways that a given integer <code>value</code>
     * can be expressed as the sum of the Nth power of unique, natural numbers by recursion.
     *
     * @param value given value
     * @param power power
     * @param start value from which we start to search
     * @return number of ways.
     */
    static int findByRecursion(int value, int power, int start) {
        if (value == 0) {
            return 1;
        }

        int counter = 0;
        for (int i = start + 1; (int) Math.pow(i, power) <= value; i++) {
            counter += findByRecursion(value - (int) Math.pow(i, power), power, i);
        }
        return counter;
    }
}
