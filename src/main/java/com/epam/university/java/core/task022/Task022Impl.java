package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        List<Integer> myList = numbers.stream().collect(Collectors.toList());
        Collections.sort(myList);
        Collections.reverse(myList);
        int countMax = 0;

        for (int i = 0; i < myList.size() - 1; i++) {
            countMax += myList.get(i);
        }

        return countMax;
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        List<Integer> myList = numbers.stream().collect(Collectors.toList());
        Collections.sort(myList);
        int countMin = 0;

        for (int i = 0; i < myList.size() - 1; i++) {
            countMin += myList.get(i);
        }

        return countMin;
    }
}
