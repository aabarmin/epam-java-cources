package com.epam.university.java.core.task022;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(numbers.size() - 1)
                .reduce((integer, integer2) -> integer + integer2)
                .orElse(0);
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .limit(numbers.size() - 1)
                .reduce((integer, integer2) -> integer + integer2)
                .orElse(0);
    }
}
