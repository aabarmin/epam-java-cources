package com.epam.university.java.core.task022;

import java.util.Collection;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        int sum = 0;
        int minNumber = Integer.MAX_VALUE;
        for (Integer number : numbers) {
            if (number < minNumber) {
                minNumber = number;
            }
            sum += number;
        }
        return sum - minNumber;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        int sum = 0;
        int maxNumber = Integer.MIN_VALUE;
        for (Integer number : numbers) {
            if (number > maxNumber) {
                maxNumber = number;
            }
            sum += number;
        }
        return sum - maxNumber;
    }
}
