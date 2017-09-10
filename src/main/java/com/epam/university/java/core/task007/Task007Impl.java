package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
        Collection<Integer> second) {
        List<Integer> firstPolinomial = new ArrayList<>(first);
        List<Integer> secondPolinomial = new ArrayList<>(second);
        Integer[] result = new Integer[firstPolinomial.size() + secondPolinomial.size()];
        Arrays.fill(result, 0);
        for (int i = 0; i < firstPolinomial.size(); i++) {
            for (int j = 0; j < secondPolinomial.size(); j++) {
                result[i + j] += firstPolinomial.get(i) * secondPolinomial.get(j);
            }
        }
        return Arrays.asList(result);
    }
}

