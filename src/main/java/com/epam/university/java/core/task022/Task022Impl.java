package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Александр on 26.09.2017.
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
        return numbers.stream()
                .mapToInt(Integer::intValue).sorted()
                .skip(1)
                .sum();
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
        return numbers.stream()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .skip(1)
                .sum();
    }
}
