package com.epam.university.java.core.task022;

import java.util.Collection;


/**
 * {@inheritDoc}
 */
public class Task022Impl implements Task022 {
    /**
     * {@inheritDoc}
     */
    @Override
    public int maxSum(Collection<Integer> numbers) {
        int i = numbers.stream().
                sorted((a, b) -> b - a).
                limit(numbers.size() - 1).
                reduce(0, (a, b) -> a + b);
        return i;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int minSum(Collection<Integer> numbers) {
        int i = numbers.stream().
                sorted().
                limit(numbers.size() - 1).
                reduce(0, (a, b) -> a + b);
        return i;
    }
}
