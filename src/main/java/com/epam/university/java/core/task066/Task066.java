package com.epam.university.java.core.task066;

/**
 * Repeat the string.
 */

public interface Task066 {
    /**
     * <p>
     * Given an long limiter and String, find the number
     * of letter 'a' in the first limiter letters of infinite input String.
     *
     * For example, if the String s = "abcac", and int limiter = 10,
     * the substring we consider is "abcacabcac", the first 10 characters
     * of this infinite string. There are 4 occurrences of 'a' in the substring.
     *
     * Ex.2  ("layla", 9) -> laylalayl -> output 3;
     * Ex.3 ("pancho", 20) -> panchopanchopanchopa -> output 4;
     *
     * </p>
     *
     * @param limiter long
     * @param infiniteString String
     * @return long - the count of 'a's.
     */

    long repeatString(String infiniteString, long limiter);
}
