package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    private int locValue;
    private int locPower;
    private int numberOfWays;

    /**
     * Find the number of ways that a given integer <code>locValue</code> can be expressed as the
     * sum of the Nth locPower of unique, natural numbers.
     *
     * <p>
     *     Examples:
     *          locValue is 10, locPower is 2, result is 1 because 10 = 1^2 + 3^2
     *          locValue is 100, locPower is 2, result is 3 because 100 = 10^2 =
     *                  6^2 + 8^2 = 1^2 + 3^2 + 4^2 + 5^2 + 7^2
     * </p>
     *
     * @param value locValue number
     * @param power locPower
     * @return number of ways
     */
    @Override
    public int getWays(int value, int power) {
        this.locValue = value;
        this.locPower = power;
        findTheDecomposition(0, 1);
        return numberOfWays;
    }

    private void findTheDecomposition(int sum, int number) {
        int sumAdd = (int) Math.pow(number, locPower);

        if (sumAdd <= locValue - sum) {
            findTheDecomposition(sum, number + 1);
            sum += sumAdd;
            if (sum == locValue) {
                numberOfWays++;
            } else if (sum < locValue) {
                findTheDecomposition(sum, number + 1);
            }
        }
    }
}
