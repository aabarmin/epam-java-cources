package com.epam.university.java.core.task059;

/**
 * Count sort.
 *
 * <p>
 *     Given a list of integers. Every number is > 0 and < 10.
 *     Need to sort the sequence. Algorithm complexity must be O(n).
 * </p>
 */
public interface Task059 {
    /**
     * Returns sorted sequence.
     *
     * @param sequence array to sort
     * @return sorted array
     */
    int[] countSort(int[] sequence);
}
