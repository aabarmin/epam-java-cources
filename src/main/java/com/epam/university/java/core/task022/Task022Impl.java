package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Task022Impl implements Task022 {
    /**
     * Given collection of n integers, find the maximum value that can be calculated
     * by summing (n-1) integers.
     *
     * @param numbers collection of numbers
     * @return maximum value
     */
    @Override
    public int maxSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> nums = Arrays.asList(numbers.toArray(new Integer[0]));
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int sum = 0;
        for (int i = 1; i < nums.size(); i++) {
            sum += nums.get(i);
        }
        return sum;
    }

    /**
     * Given collection of n integer, find the minimum value that can ba calculated
     * by summing (n-1) integers.
     *
     * @param numbers collection of numbers
     * @return minimum value
     */
    @Override
    public int minSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
        List<Integer> nums = Arrays.asList(numbers.toArray(new Integer[0]));
        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int sum = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            sum += nums.get(i);
        }
        return sum;
    }
}
