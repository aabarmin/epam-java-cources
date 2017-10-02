package com.epam.university.java.core.task022;

import java.util.Collection;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Collection wasn't provided!");
        }
        return numbers.stream()
                .sorted()
                .skip(1)
                .reduce(0, (a, b) -> a + b);
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Collection wasn't provided!");
        }
        return numbers.stream()
                .sorted()
                .limit(numbers.size() - 1)
                .reduce(0, (a, b) -> a + b);
    }
}