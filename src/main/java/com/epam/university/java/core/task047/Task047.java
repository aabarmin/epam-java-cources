package com.epam.university.java.core.task047;

/**
 * Number of inversions.
 *
 * <p>
 *     Given n such as 1 <= n <= 10^5. Given an array A[1...n],
 *     containing natural numbers not exceeding 10^9.
 *     It is necessary to calculate the number of pairs
 *     of indices 1 <= i < j <= n, for which A[i] > A[j].
 *     (Such a pair of elements is called an array inversion.
 *     The number of inversions in an array is, in a sense,
 *     a measure of its disorder: for example, in an array sorted in non-decreasing order,
 *     there are no inversions at all, and in an array sorted in descending order,
 *     an inversion is formed by every two elements.)
 * </p>
 * <p>
 *     Example: n = 5, A[2, 3, 9, 2, 9], result is 2.
 * </p>
 * <p>
 *     Tip: Use merge sort.
 * </p>
 *
 */

public interface Task047 {
    /**
     * Calculate number of inversions.
     * @param n number of elements in an array.
     * @param a - array of elements.
     * @return number of inversions.
     */
    long calculateInversions(int n, int[] a);
}
