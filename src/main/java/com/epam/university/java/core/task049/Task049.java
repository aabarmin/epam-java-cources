package com.epam.university.java.core.task049;


/**
 * Find longest common sequence.
 * Given two strings, write a method that finds the longest common sub-sequence.
 */
public interface Task049 {
    /**
     * Return string with longest common sequence.
     *
     * @param first  string
     * @param second string
     * @return string with longest common sequence.
     * @throws IllegalArgumentException if input parameters are not set or not valid
     */
    String getResultList(String first, String second);
}
