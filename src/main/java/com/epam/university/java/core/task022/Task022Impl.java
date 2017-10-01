package com.epam.university.java.core.task022;

import java.util.Collection;

/**
 * Implementation class for Task022.
 *
 * @author Sergei Titov
 */
public class Task022Impl implements Task022 {

    /**
     * {@inheritDoc}
     */
    @Override
    public int maxSum(Collection<Integer> numbers) {
        return goCalc(numbers, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int minSum(Collection<Integer> numbers) {
        return goCalc(numbers, false);
    }


    // calculating procedure
    private int goCalc(Collection<Integer> numbers, boolean needMax) {

        int sum = 0;
        int minus = needMax ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        for (Integer number : numbers) {
            if ((needMax && number < minus) || (!needMax && number > minus)) {
                minus = number;
            }
            sum += number;
        }
        return sum - minus;
    }
}
