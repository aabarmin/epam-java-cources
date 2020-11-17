package com.epam.university.java.core.Task069;

/**
 * Find the next number, containing same digits.
 */

public interface Task069 {
    /**
     * This function takes a positive number and returns the
     * next bigger number that can be formed by rearranging its digits.
     * If the digits can't be rearranged to form a bigger number, return -1
     * For example:
     * 12 ==> 21
     * 513 ==> 531
     * 2017 ==> 2071
     * 9 ==> -1
     * 111 ==> -1
     * 531 ==> -1
     * @param num given number
     * @return next bigger number with same digits
     * @throws IllegalArgumentException if the number is negative
     */
    long nextSameDigitsNumber(long num);
}
