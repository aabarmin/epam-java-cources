package com.epam.university.java.core.task007;

import java.util.Arrays;
import java.util.Collection;

/**
 * implementation class for Task007.
 *
 * @author Sergei Titov
 */
public class Task007Impl implements Task007 {

    /**
     * Multiply polynomials. Each collection contains coefficients near i-th member.
     *
     * @param first  collection with coefficients near-th member of first polynomial
     * @param second collection with coefficients near-th member of second polynomial
     *
     * @returns collection of members in multiplied polynomials
     */
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {

        final int n = first.size();
        final int m = second.size();

        Integer[] arrFirst = new Integer[n];
        first.toArray(arrFirst);

        Integer[] arrSecond = new Integer[m];
        second.toArray(arrSecond);

        Integer[] result = new Integer[n + m - 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (null == result[i + j]) { // without this NullPointerException occurs
                    result[i + j] = 0;
                }
                result[i + j] += (arrFirst[i] * arrSecond[j]);
            }
        }

        return Arrays.asList(result);
    }
}
