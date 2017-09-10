package com.epam.university.java.core.task007;

import java.util.Collection;

/**
 * Polynomial math.
 */
public interface Task007 {
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
    Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second);
}
