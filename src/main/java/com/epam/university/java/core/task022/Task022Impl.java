package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        validate(numbers);

        List<Integer> numbersList = new ArrayList<>(numbers);
        Collections.sort(numbersList);

        int sum = 0;
        for (int i = 1; i < numbersList.size(); i++) {
            sum += numbersList.get(i);
        }

        return sum;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        validate(numbers);

        List<Integer> numbersList = new ArrayList<>(numbers);
        Collections.sort(numbersList, Collections.reverseOrder());

        int sum = 0;
        for (int i = 1; i < numbersList.size(); i++) {
            sum += numbersList.get(i);
        }

        return sum;
    }

    private void validate(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
    }
}
