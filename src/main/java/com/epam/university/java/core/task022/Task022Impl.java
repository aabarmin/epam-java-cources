package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Comparator;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        return numbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .limit(numbers.size() - 1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        return numbers
                .stream()
                .sorted(Comparator.naturalOrder())
                .limit(numbers.size() - 1)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
