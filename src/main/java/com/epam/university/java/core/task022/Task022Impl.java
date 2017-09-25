package com.epam.university.java.core.task022;

import java.util.Collection;

/**
 * Simple mini-max sum.
 */
public class Task022Impl implements Task022 {

    /**
     * Given collection of n integers, find the maximum value that can be calculated
     * by summing (n-1) integers.
     * <p>
     *     Answer is: sum of every item except minimum in MaxHeap
     * </p>
     * @param numbers collection of numbers
     * @return maximum value
     * @see MaxHeap
     */
    @Override
    public int maxSum(Collection<Integer> numbers) {
        BinaryHeap<Integer> heap = new MaxHeap<>(numbers);
        int res = 0;
        while (heap.size() > 1) {
            res += heap.extract();
        }
        return res;
    }

    /**
     * Given collection of n integer, find the minimum value that can ba calculated
     * by summing (n-1) integers.
     * <p>
     *     Answer is: sum of every item except maximum in MinHeap
     * </p>
     * @param numbers collection of numbers
     * @return minimum value
     * @see MinHeap
     */
    @Override
    public int minSum(Collection<Integer> numbers) {
        BinaryHeap<Integer> heap = new MinHeap<>(numbers);
        int res = 0;
        while (heap.size() > 1) {
            res += heap.extract();
        }
        return res;
    }

}
