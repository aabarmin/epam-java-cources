package com.epam.university.java.core.task007;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task007Impl implements Task007 {

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        int[] polynomFirst = first.stream().mapToInt(Integer::intValue)
                .toArray();
        int[] polynomSecond = second.stream().mapToInt(Integer::intValue)
                .toArray();
        int[] polynomResult = new int[polynomFirst.length
                + polynomSecond.length - 1];
        for (int i = 0; i < polynomFirst.length; i++) {
            for (int j = 0; j < polynomSecond.length; j++) {
                polynomResult[i + j] += (polynomFirst[i] * polynomSecond[j]);
            }
        }
        return (IntStream.of(polynomResult).boxed().collect(Collectors
                .toList()));
    }
}