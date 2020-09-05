package com.epam.university.java.core.task007;

import java.util.Arrays;
import java.util.Collection;

public class Task007Impl implements Task007 {
    /**
     * Multiply polynomials. Each collection contains coefficients near i-th member, ex:
     * <p>
     *     3x^3 + 2x^2 - 5x corresponds to collection [3, 2, -5, 0]
     * </p>
     * <p>
     *     Task is to multiply two polynomials: ex:
     * </p>
     * <p>
     *     (3x^3 + 2x^2 - 5x) * (4x^4 + 2x^2) == multiplyPolynomial([3, 2, -5, 0], [4, 0, 2, 0, 0])
     * </p>
     * <p>
     *     If polynomial is degenerating to zero, return [0]
     * </p>
     *
     * @param first collection with coefficients near-th member of first polynomial
     * @param second collection with coefficients near-th member of second polynomial
     * @return collection of members in multiplied polynomials
     */

    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        Integer[] firstArr = first.toArray(new Integer[first.size()]);
        Integer[] secondArr = second.toArray(new Integer[second.size()]);
        Integer[] resultArr = new Integer[firstArr.length + secondArr.length - 1];

        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = 0;
        }

        for (int i = 0; i < firstArr.length; i++) {
            for (int j = 0; j < secondArr.length; j++) {
                resultArr[i + j] += firstArr[i] * secondArr[j];
            }
        }

        Collection<Integer> result = Arrays.asList(resultArr);
        return result;
    }
}
