package com.epam.university.java.core.task022;

import java.util.Collection;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        return numbers.stream().mapToInt(s -> s).sorted().skip(1).sum();
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        return numbers.stream().mapToInt(s -> s).sorted().limit(numbers.size() - 1).sum();
    }
}
