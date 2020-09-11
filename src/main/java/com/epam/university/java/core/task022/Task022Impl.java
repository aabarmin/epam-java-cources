package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Romin Nuro on 11.09.2020 13:29.
 */
public class Task022Impl implements Task022 {
    /**
     * Given collection of n integers, find the maximum value that can be calculated
     * by summing (n-1) integers.
     *
     * @param numbers collection of numbers
     * @return maximum value
     */
    @Override
    public int maxSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
        return numbers.stream().reduce(Integer::sum).orElse(0) - Collections.min(numbers);
    }

    /**
     * Given collection of n integer, find the minimum value that can ba calculated
     * by summing (n-1) integers.
     *
     * @param numbers collection of numbers
     * @return minimum value
     */
    @Override
    public int minSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
        return numbers.stream().reduce(Integer::sum).orElse(0) - Collections.max(numbers);
    }
}
