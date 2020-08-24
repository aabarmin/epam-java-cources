package com.epam.university.java.core.task007;


import java.util.Collections;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        List<Integer> firstList = new ArrayList<>(first);
        List<Integer> secondList = new ArrayList<>(second);

        int arrSize;
        int sumSizes = first.size() + second.size();
        if (sumSizes <= 2) {
            arrSize = 1;
        } else if (sumSizes == 3) {
            arrSize = 2;
        } else if (sumSizes == 4) {
            arrSize = 3;
        } else {
            arrSize = first.size() - 1 + second.size();
        }

        Integer[] multiplyArr = new Integer[arrSize];

        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < secondList.size(); j++) {
                int element = firstList.get(i) * secondList.get(j);
                int index = arrSize - 1 - (i + j);
                if (multiplyArr[index] == null) {
                    multiplyArr[index] = element;
                } else {
                    multiplyArr[index] += element;
                }
            }
        }

        List<Integer> integers = new ArrayList<>(Arrays.asList(multiplyArr));
        Collections.reverse(integers);

        return integers;
    }
}
