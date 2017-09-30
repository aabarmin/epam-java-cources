package com.epam.university.java.core.task022;

import com.epam.university.java.core.task015.Point;

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

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(Integer number : numbers) {
            if(number < min) {
                min = number;
            }
            sum += number;
        }
        return sum - min;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int minSum(Collection<Integer> numbers) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for(Integer number : numbers) {
            if(number > max) {
                max = number;
            }
            sum += number;
        }
        return sum - max;
    }
}
