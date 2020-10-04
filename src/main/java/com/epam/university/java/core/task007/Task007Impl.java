package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Task007Impl implements Task007 {
    /**
     * Multiply polynomials. Each collection contains coefficients near i-th member, ex:
     * <p>
     * 3x^3 + 2x^2 - 5x corresponds to collection [3, 2, -5, 0]
     * </p>
     * <p>
     * Task is to multiply two polynomials: ex:
     * </p>
     * <p>
     * (3x^3 + 2x^2 - 5x) * (4x^4 + 2x^2) == multiplyPolynomial([3, 2, -5, 0], [4, 0, 2, 0, 0])
     * </p>
     * <p>
     * If polynomial is degenerating to zero, return [0]
     * </p>
     *
     * @param first  collection with coefficients near-th member of first polynomial
     * @param second collection with coefficients near-th member of second polynomial
     * @return collection of members in multiplied polynomials
     */
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        Integer[] firstPoly = first.toArray(new Integer[first.size()]);
        Integer[] secondPoly = second.toArray(new Integer[second.size()]);
        int sizeOfResult = firstPoly.length + secondPoly.length - 1;
        Integer[] result = Collections.nCopies(sizeOfResult, 0).toArray(new Integer[0]);
        for (int i = 0; i < firstPoly.length; i++) {
            for (int j = 0; j < secondPoly.length; j++) {
                result[i + j] = (result[i + j] + firstPoly[i] * secondPoly[j]);
            }
        }
        boolean isZeros = true;
        for (int i = 0; i < result.length; i++) {
            if (result[i] != 0) {
                isZeros = false;
                break;
            }
        }
        if (isZeros) {
            Integer[] arr = {0};
            List<Integer> res = Arrays.asList(arr);
            return res;
        } else {
            List<Integer> res = Arrays.asList(result);
            return res;
        }
    }
}
