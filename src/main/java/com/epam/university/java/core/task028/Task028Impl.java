package com.epam.university.java.core.task028;

/**
 * Created by Romin Nuro on 11.09.2020 13:42.
 */
public class Task028Impl implements Task028 {
    /**
     * Find the number of ways that a given integer <code>value</code> can be expressed as the
     * sum of the Nth power of unique, natural numbers.
     *
     * <p>
     * Examples:
     * value is 10, power is 2, result is 1 because 10 = 1^2 + 3^2
     * value is 100, power is 2, result is 3 because 100 = 10^2 =
     * 6^2 + 8^2 = 1^2 + 3^2 + 4^2 + 5^2 + 7^2
     * </p>
     *
     * @param value value number
     * @param power power
     * @return number of ways
     */
    @Override
    public int getWays(int value, int power) {
        return waysCount(value, power, 1);
    }

    private int waysCount(int value, int power, int start) {
        int delta = (int) (value - Math.pow(start, power));
        if (delta == 0) {
            return 1;
        }
        if (delta < 0) {
            return 0;
        }
        return waysCount(value, power, start + 1) + waysCount(delta, power, start + 1);
    }
}
