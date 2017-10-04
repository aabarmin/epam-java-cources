package com.epam.university.java.core.task022;

import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        list.addAll(numbers);
        list.sort(Comparator.naturalOrder());
        list.remove(0);
        int result = list.stream().mapToInt(n -> n).sum();
        return result;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        list.addAll(numbers);
        list.sort(Comparator.reverseOrder());
        list.remove(0);
        int result = list.stream().mapToInt(n -> n).sum();
        return result;
    }
}