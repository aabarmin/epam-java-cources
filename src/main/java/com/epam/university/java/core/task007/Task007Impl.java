package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        Collection<Integer> mul = new ArrayList<>();
        Integer[][] mulArray = new Integer[first.size()][second.size()];
        int i = 0;
        int j;
        for (Integer firstCoefficient : first) {
            j = 0;
            for (Integer secondCoefficient : second) {
                mulArray[i][j++] = firstCoefficient * secondCoefficient;
            }
            i++;
        }

        int[] output = new int[first.size() + second.size() - 1];
        for (i = 0; i < first.size(); i++) {
            for (j = 0; j < second.size(); j++) {
                output[i + j] += mulArray[i][j];
            }
        }
        for (i = 0; i < output.length; i++) {
            mul.add(output[i]);
        }

        return mul;

    }
}
