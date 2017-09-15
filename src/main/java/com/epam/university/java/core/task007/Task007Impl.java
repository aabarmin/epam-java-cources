package com.epam.university.java.core.task007;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        Integer[] firstArr = new Integer[first.size()];
        first.toArray(firstArr);
        Integer[] secondArr = new Integer[second.size()];
        second.toArray(secondArr);
        int[] resultArr = new int[first.size() + second.size()];

        for (int i = 0; i < firstArr.length; i++) {
            for (int j = 0; j < secondArr.length; j++) {
                int index = i + j;
                int multOfElements = firstArr[i] * secondArr[j];

                if (resultArr[index] != 0) {
                    resultArr[index] += multOfElements;
                } else {
                    resultArr[index] = multOfElements;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i : resultArr) {
            list.add(i);
        }
        if (list.lastIndexOf(0) == list.size() - 1) {
            list.remove(list.size() - 1);
        }
        return list;
    }
}
