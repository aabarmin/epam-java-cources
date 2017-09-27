package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.concurrent.atomic.LongAdder;

/**
 * Simple mini-max sum.
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

        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException();
        }

        final LongAdder adder = new LongAdder();
        final MinMaxInteger minMaxInteger = new MinMaxInteger();

        numbers.stream().forEach(i -> {
            adder.add(i);
            minMaxInteger.min(i);
        });

        int result = adder.intValue() - minMaxInteger.getMin();

        return result;

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

        if (numbers == null || numbers.size() < 2) {
            throw new IllegalArgumentException();
        }

        final LongAdder adder = new LongAdder();
        final MinMaxInteger minMaxInteger = new MinMaxInteger();

        numbers.stream().forEach(i -> {
            adder.add(i);
            minMaxInteger.max(i);
        });

        int result = adder.intValue() - minMaxInteger.getMax();

        return result;

    }
}


