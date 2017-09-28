package com.epam.university.java.core.task022;

import java.util.Collection;

/**
 * Created by Daniil Smirnov on 26.09.2017.
 * All copy registered MF.
 */
public class Task022Impl implements Task022 {

    @Override
    public int maxSum(Collection<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .skip(1)
                .mapToInt(Integer::intValue)
                .sum();
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .limit(numbers.size() - 1)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
