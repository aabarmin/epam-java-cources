package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Romin Nuro on 25.08.2020 1:33.
 */
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
    public Collection<Integer>
        multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < first.size() + second.size() - 1; i++) {
            result.add(i, 0);
        }

        for (int i = 0; i < first.size(); i++) {
            for (int j = 0; j < second.size(); j++) {
                int product = result.get(i + j)
                        + ((List<Integer>) first).get(i) * ((List<Integer>) second).get(j);
                result.remove(i + j);
                result.add(i + j, product);
            }

        }
        return result;
    }
}
