package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task007Impl implements Task007 {
    /**
     * Multiply polynomials. Each collection contains coefficients near i-th member, ex:
     * <p>
     * 3x^3 + 2x^2 - 5x corresponds to collection [3, 2, -5]
     * <p>
     * Task is to multiply two polynomials: ex:
     * <p>
     * (3x^3 + 2x^2 - 5x) * (4x^4 + 2x^2) == multiplyPolynomial([3, 2, -5], [4, 0, 2, 0])
     * <p>
     * If polynomial is degenerating to zero, return [0]
     *
     * @param first
     * @param second
     * @return
     */
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first, Collection<Integer> second) {

        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }

        if (first.size() == 0 || second.size() == 0) {
            return Arrays.asList(0);
        }

        Integer[] result = new Integer[first.size() + second.size()];
        Arrays.fill(result, 0);

        int powerFirst = first.size();

        for (int firstElement : first) {

            int powerSecond = second.size();

            for (int secondElement : second) {

                int index = result.length - (powerFirst + powerSecond);

                result[index] = result[index] + (firstElement * secondElement);

                powerSecond--;

            }

            powerFirst--;

        }

        return Arrays.asList(result);

    }
}
