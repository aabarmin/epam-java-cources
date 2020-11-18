package com.epam.university.java.core.task070;

import java.util.Collection;

/**
 * You have to find a collection of Smith Numbers within the range.
 * Smith number is a composite number for which, in a given number base, the sum of its digits
 * is equal to the sum of the digits in its prime factorization in the given number base.
 * For example 202 is Smith number:
 * 202 = 2 * 101, because 2 + 0 + 2 = 4 and 2 + 1 + 0 + 1 = 4
 *
 */
public interface Task070 {
    /**
     * Return collection of Smith numbers.
     *
     * @param from int value of start range number
     * @param to int value of end range number
     * @return collection of Smith numbers
     * @throws IllegalArgumentException if input parameters are not provided
     */
    Collection<Integer> getSmithNumbers(Integer from, Integer to);
}
