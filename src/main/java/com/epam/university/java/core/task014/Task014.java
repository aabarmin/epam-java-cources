package com.epam.university.java.core.task014;

import java.util.Collection;

/**
 * Vampire numbers.
 */
public interface Task014 {
    /**
     * A vampire number has an even number of digits and is formed by
     * multiplying a pair of numbers containing half the number of digits
     * of the result. The digits are taken from the original number
     * in any order. Pairs of trailing zeroes are not allowed.
     *
     * <p>
     *     Example: 1260 = 21 * 60
     * </p>
     * <p>
     *     {@see https://en.wikipedia.org/wiki/Vampire_number}
     * </p>
     * @return collection of vampire numbers
     */
    Collection<VampireNumber> getVampireNumbers();
}
