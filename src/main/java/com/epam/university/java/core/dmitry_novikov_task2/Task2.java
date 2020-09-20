package com.epam.university.java.core.dmitry_novikov_task2;

/**
 * Find longest common sequence.
 * Given two strings, write a method that finds the longest common sub-sequence.
 */
public interface Task2 {
    /**
     * Return string with longest common sequence.
     *
     * @param first string
     * @param second string
     * @return string with longest common sequence.
     * @throws IllegalArgumentException if input parameters are not set or not valid
     */
    String getResultList(String first, String second);
}
