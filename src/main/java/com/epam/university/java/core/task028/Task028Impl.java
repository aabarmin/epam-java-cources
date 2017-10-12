package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    private int result = 0;

    @Override
    public int getWays(int value, int power) {
        calculateWays(value, value, power, 0);
        return result;

    }

    /**
     * function of recursive finding number of ways to express <code>value</code>
     * as the sum of Nth power of unique, natural numbers.
     *
     * @param value     source value for calculating
     * @param remaining remaining part of value, need for calculating.
     * @param power     N
     * @param used      last used number, need for calculating
     */
    private void calculateWays(int value, int remaining, int power, int used) {
        if (remaining == 0) {
            result++;
        }
        if (remaining > 0) {
            int root = (int) Math.pow(value, 1.0 / power);
            for (int i = used + 1; i <= root; i++) {
                int newRemaining = (remaining - (int) Math.pow(i, power));
                if (newRemaining >= 0) {
                    calculateWays(value, newRemaining, power, i);
                } else {
                    break;
                }
            }
        }
    }

}
