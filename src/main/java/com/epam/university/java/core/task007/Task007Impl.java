package com.epam.university.java.core.task007;

import com.epam.university.java.core.util.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of the polynomial math.
 */
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
        Utils.assertNonNull(first, second);
        ArrayList<Integer> firstList = new ArrayList<>(first);
        ArrayList<Integer> secondList = new ArrayList<>(second);
        List<Integer> res =
            new ArrayList<>(Collections.nCopies(firstList.size() + secondList.size(), 0));
        for (int i = 0; i < firstList.size(); ++i) {
            for (int j = 0; j < secondList.size(); ++j) {
                res.set(i + j, res.get(i + j) + firstList.get(i) * secondList.get(j));
            }
        }
        int firstNonZero = 0;
        while (firstNonZero < res.size() && res.get(firstNonZero) == 0) {
            ++firstNonZero;
        }
        res = res.subList(firstNonZero, res.size());
        return res.isEmpty() ? Collections.singletonList(0) : res;
    }

}
