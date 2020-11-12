package com.epam.university.java.core.task063;

/**
 * You have to find a digital root of given number.
 * Digital root of a natural number is the (single digit) value obtained by
 * an iterative process of summing digits, on each iteration using the result from
 * the previous iteration to compute a digit sum.
 * The process continues until a single-digit number is reached. Ex:
 * <p>
 *      for number 128 digital root equal 2
 *      1 + 2 + 8 = 11 and 1 + 1 = 2
 * </p>
 */

public interface Task063 {
    /**
     * Calculate digital root of given number.
     *
     * @param number given number for calculation
     * @return digital root
     * @throws IllegalArgumentException if number not provided
     */
    Integer calcDigitalRoot(Integer number);
}
