package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task022Impl implements Task022 {

    @Override
    public int maxSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        list.remove(0);
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        if (numbers == null || numbers.size() == 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        list.remove(list.size() - 1);
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
