package com.epam.university.java.core.task007;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        int size1 = first.size();
        int size2 = second.size();
        Integer[] firstArr = first.toArray(Integer[]::new);
        Integer[] secondArr = second.toArray(Integer[]::new);
        Integer[] res = new Integer[size1 + size2 - 1];
        Arrays.fill(res, 0);

        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                res[i + j] += firstArr[i] * secondArr[j];
            }
        }

        return Arrays.asList(res);
    }
}
