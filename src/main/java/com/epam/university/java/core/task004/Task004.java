package com.epam.university.java.core.task004;

/**
 * Advanced tasks with arrays.
 */
public interface Task004 {
    /**
     * Find intersection of two arrays.
     *
     * @param first first array
     * @param second second array
     * @return array of common elements
     * @throws IllegalArgumentException if parameters not provided
     */
    String[] intersection(String[] first, String[] second);

    /**
     * Find union of two arrays.
     *
     * @param first first array
     * @param second second array
     * @return array of all elements of array
     * @throws IllegalArgumentException if parameters not provided
     */
    String[] union(String[] first, String[] second);
}