package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Collections;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        final int min = Collections.min(numbers);
        return numbers.stream().mapToInt(s -> s).sum() - min;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        final int max = Collections.max(numbers);
        return numbers.stream().mapToInt(s -> s).sum() - max;
    }
}
