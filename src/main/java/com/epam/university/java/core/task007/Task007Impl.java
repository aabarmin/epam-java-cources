package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Daniil Smirnov on 14.09.2017.
 * All copy registered MF.
 */
public class Task007Impl implements Task007 {

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        int maxIndex = first.size() + second.size() - 1;

        Integer[] firstP = (Integer[]) first.toArray();
        Integer[] secondP = (Integer[]) second.toArray();

        Integer[] result = new Integer[firstP.length + secondP.length - 1];
        Arrays.fill(result,0);

        for (int i = 0; i < firstP.length; i++) {
            for (int j = 0; j < secondP.length; j++) {
                result[i + j] += firstP[i] * secondP[j];
            }
        }
        return Arrays.asList(result);
    }
}
