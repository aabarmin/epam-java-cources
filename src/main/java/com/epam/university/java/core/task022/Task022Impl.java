package com.epam.university.java.core.task022;

import java.util.Arrays;
import java.util.Collection;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        Integer[] numbersArray = numbers.toArray(new Integer[0]);
        Arrays.sort(numbersArray);
        int summ = Arrays.stream(Arrays.copyOfRange(numbersArray,
                1, numbersArray.length)).parallel()
                .mapToInt(Integer::intValue).sum();
        return summ;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        Integer[] numbersArray = numbers.toArray(new Integer[0]);
        Arrays.sort(numbersArray);
        System.out.println(numbersArray);
        int summ = Arrays.stream(Arrays.copyOfRange(numbersArray,
                0, numbersArray.length - 1)).parallel()
                .mapToInt(Integer::intValue).sum();
        return summ;
    }
}