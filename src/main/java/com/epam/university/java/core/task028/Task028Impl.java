package com.epam.university.java.core.task028;

import java.util.ArrayList;
import java.util.List;
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

        // could be done without multithreading
        if (value < 1000) {

            for (int i = 1; i <= max; i++) {
                final int remainingValue = value - (int) Math.pow(i, power);
                if (remainingValue > 0) {
                    task028Inner.checkRecursive(remainingValue, i);
                } else {
                    task028Inner.incrementCounter(remainingValue == 0);
                }
            }

        // do it with multithreading
        } else {

            List<Thread> threads = new ArrayList<>();

            for (int i = 1; i <= max; i++) {
                final int z = i;
                final int remainingValue = value - (int) Math.pow(i, power);
                if (remainingValue > 0) {
                    Thread thread = new Thread(() -> {
                        task028Inner.checkRecursive(remainingValue, z);
                    });
                    threads.add(thread);
                    thread.start();
                } else {
                    task028Inner.incrementCounter(remainingValue == 0);
                }
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        return task028Inner.getCounterValue();

    }

    private class Task028Inner {

        private final int max;
        private final int power;
        private AtomicInteger counter = new AtomicInteger(0);

        public Task028Inner(int max, int power) {
            this.max = max;
            this.power = power;
        }

        public int getCounterValue() {
            return counter.intValue();
        }

        public void incrementCounter(boolean increment) {
            if (increment) {
                counter.incrementAndGet();
            }
        }

        public void checkRecursive(int value, int k) {

            for (int i = k + 1; i <= max; i++) {
                int remainingValue = value - (int) Math.pow(i, power);
                if (remainingValue > 0) {
                    checkRecursive(remainingValue, i);
                } else {
                    incrementCounter(remainingValue == 0);
                    return;
                }
            }

        }

    }

}
