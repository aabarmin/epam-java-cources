package com.epam.university.java.core.task028;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Class implements <code>Task028</code> interface.
 */
public class Task028Impl implements Task028 {

    @Override
    public int getWays(int value, int power) {
        return getWaysRecursion(value, power, 1, 0);
    }

    /**
     * Get number of ways that a given integer <code>givenValue</code> can be
     * expressed as the sum of the Nth power of unique, natural numbers.
     *
     * @param givenValue given number
     * @param powerN     power for the solving
     * @param num        number to start with
     * @param sum        sum of numbers to check
     */
    private static int getWaysRecursion(int givenValue, int powerN, int num,
                                        double sum) {
        Validator.validateNotNegative(givenValue, powerN,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NEGATIVE,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NEGATIVE);
        if (sum == givenValue) {
            return 1;
        } else {
            int waysNumber = 0;
            if (sum < givenValue) {
                for (int i = num; i <= Math.pow(givenValue, 1.0 / powerN);
                     i++) {
                    waysNumber += getWaysRecursion(givenValue, powerN,
                            i + 1, sum + Math.pow(i, powerN));
                }
            }
            return waysNumber;
        }
    }
}