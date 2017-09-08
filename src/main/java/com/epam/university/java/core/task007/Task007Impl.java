package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Polynomial math.
 */
public class Task007Impl implements Task007 {

    /**
     * * Message for the case input polynoms not provided.
     */
    private static final String MSG_NO_ARGS = "polynoms not provided";

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {
        if ((null==first)||(null==second)) throw new IllegalArgumentException(MSG_NO_ARGS);

        List<Integer> firstPolynom = new ArrayList<>(first);
        List<Integer> secondPolynom = new ArrayList<>(second);
        Integer[] resultArray = new Integer[firstPolynom.size() + secondPolynom.size()];

        Arrays.fill(resultArray, 0);
        for (int i = 0; i < firstPolynom.size(); i++) {
            for (int j = 0; j < secondPolynom.size(); j++) {
                resultArray[i + j] += firstPolynom.get(i) * secondPolynom.get(j);
            }
        }
        return Arrays.asList(resultArray);
    }
}
