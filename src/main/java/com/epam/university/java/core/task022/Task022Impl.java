package com.epam.university.java.core.task022;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task022Impl implements Task022{
    @Override
    public int maxSum(Collection<Integer> numbers) {
        final ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        int sum = 0;
        for (int i = list.size() - 1; i > 0 ; i--) {
            sum += list.get(i);
        }
        return sum;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        final ArrayList<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        int sum = 0;
        for (int i = 0 ; i < list.size()-1 ; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
