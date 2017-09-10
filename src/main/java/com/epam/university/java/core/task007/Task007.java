package com.epam.university.java.core.task007;

import java.util.Collection;

/**
 * Polynomial math.
 */
public interface Task007 {
    /**
     * Multiply polynomials. Each collection contains coefficients near i-th member, ex:
     *
     * 3x^3 + 2x^2 - 5x corresponds to collection [3, 2, -5]
     *
     * Task is to multiply two polynomials: ex:
     *
     * (3x^3 + 2x^2 - 5x) * (4x^4 + 2x^2) == multiplyPolynomial([3, 2, -5], [4, 0, 2, 0])
     *
     * If polynomial is degenerating to zero, return [0]
     *
     * @param first
     * @param second
     * @return
     */
    Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second);
}
