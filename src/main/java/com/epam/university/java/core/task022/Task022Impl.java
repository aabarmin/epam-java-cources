package com.epam.university.java.core.task022;

import java.util.Collection;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }

        int sum = numbers.stream()
                .mapToInt((s) -> Integer.parseInt(String.valueOf(s)))
                .sum();
        int min = numbers.stream()
                .min(Integer::compareTo)
                .get();
        int maxSum = sum - min;
        return maxSum;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
        int sum = numbers.stream()
                .mapToInt((s) -> Integer.parseInt(String.valueOf(s)))
                .sum();
        int max = numbers.stream()
                .max(Integer::compareTo)
                .get();
        int minSum = sum - max;
        return minSum;
    }
}
