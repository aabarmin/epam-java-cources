package com.epam.university.java.core.task022;

import java.util.Collection;

/**
 * Simple mini-max sum.
 */
public interface Task022 {
    /**
     * Given collection of n integers, find the maximum value that can be calculated
     * by summing (n-1) integers.
     * @param numbers collection of numbers
     * @return maximum value
     */
    int maxSum(Collection<Integer> numbers);

    /**
     * Given collection of n integer, find the minimum value that can ba calculated
     * by summing (n-1) integers.
     * @param numbers collection of numbers
     * @return minimum value
     */
    int minSum(Collection<Integer> numbers);
}
