package com.epam.university.java.core.task003;

/**
 * Work with arrays and simple algorithms.
 */
public interface Task003 {
    /**
     * Invert array.
     *
     * @param source source array
     * @return inverted array
     * @throws IllegalArgumentException if array not provided
     */
    String[] invert(String[] source);

    /**
     * Join two arrays.
     *
     * @param first first array
     * @param second second array
     * @return new array which contains items from first and second arrays
     * @throws IllegalArgumentException if arrays not provided
     */
    String[] join(String[] first, String[] second);

    /**
     * Find max element in array.
     *
     * @param source source array
     * @return value of maximal element in array
     * @throws IllegalArgumentException if array not provided
     */
    int findMax(int[] source);

    /**
     * Filter array elements in accordance with condition.
     *
     * @param source source array
     * @param condition condition instance
     * @return filtered array
     * @throws IllegalArgumentException if array or condition not provided
     */
    String[] filter(String[] source, FilteringCondition condition);

    /**
     * Remove elements from source array.
     *
     * @param source source array
     * @param toRemote elements to remove
     * @return new array without removed elements
     * @throws IllegalArgumentException if parameters not provided
     */
    String[] removeElements(String[] source, String[] toRemove);

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    String[] map(String[] source, MappingOperation operation);

    /**
     * Convert source array in accordance with provided operation.
     *
     * @param source source array
     * @param operation operation instance
     * @return converted array
     * @throws IllegalArgumentException if parameters not provided
     */
    String[] flatMap(String[] source, FlatMappingOperation operation);
}
