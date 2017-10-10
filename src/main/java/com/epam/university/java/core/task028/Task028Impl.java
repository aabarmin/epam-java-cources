package com.epam.university.java.core.task028;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Recursion.
 */
public class Task028Impl implements Task028 {

    /**
     * Find the number of ways that a given integer <code>value</code> can be expressed as the
     * sum of the Nth power of unique, natural numbers.
     *
     * <p>
     *     Examples:
     *          value is 10, power is 2, result is 1 because 10 = 1^2 + 3^2
     *          value is 100, power is 2, result is 3 because 100 = 10^2 =
     *                  6^2 + 8^2 = 1^2 + 3^2 + 4^2 + 5^2 + 7^2
     * </p>
     *
     * @param value value number
     * @param power power
     * @return number of ways
     */
    @Override
    public int getWays(int value, int power) {

        int max = (int) Math.pow(value, 1.0 / power);
        final Task028Inner task028Inner = new Task028Inner(max, power);
        task028Inner.checkRecursive(value, 0);
        return task028Inner.getCounter();

    }

    private class Task028Inner {

        private final int max;
        private final int power;
        private int counter;

        public Task028Inner(int max, int power) {
            this.max = max;
            this.power = power;
        }

        public int getCounter() {
            return counter;
        }

        public void checkRecursive(int value, int k) {

            if (value == 0) {
                this.counter++;
                return;
            }

            for (int i = k + 1; i <= this.max; i++) {
                int remainingValue = value - (int) Math.pow(i, power);
                if (remainingValue >= 0) {
                    checkRecursive(remainingValue, i);
                }
            }

        }

    }

}
