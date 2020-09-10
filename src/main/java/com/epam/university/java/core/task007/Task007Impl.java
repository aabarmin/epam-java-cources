package com.epam.university.java.core.task007;

import java.util.Arrays;
import java.util.Collection;

public class Task007Impl implements Task007 {

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        Integer[] firstArr = first.toArray(Integer[]::new);
        Integer[] secondArr = second.toArray(Integer[]::new);
        int arrSize = first.size() + second.size() - 1;
        Integer[] arr = new Integer[arrSize];
        Arrays.fill(arr, 0);
        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                arr[i + j] += firstArr[i] * secondArr[j];
            }
        }
        return Arrays.asList(arr);
    }

}
