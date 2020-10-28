package com.epam.university.java.core.task048;

import java.util.Collection;

/**
 * You have to find a set of Armstrong Numbers within the range.
 * Armstrong number is a positive integer of order n
 * if abcd... = a^n + b^n + c^n + d^n + ...
 * For example:
 * 153 = 1^3 + 5^3 + 3^3
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 *
 */
public interface Task048 {
    /**
     * Return collection of Armstrong numbers.
     *
     * @param from int value of start range number
     * @param to int value of end range number
     * @return collection of Armstrong numbers
     * @throws IllegalArgumentException if input parameters are not set or not valid
     */
    Collection<Integer> getArmstrongNumbers(Integer from, Integer to);
}
