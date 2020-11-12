package com.epam.university.java.core.task058;

/**
 * Spiral matrix.
 *
 * <p>
 *     Given a number N > 0. It is necessary to fill the matrix of order N
 *     as a spiral clockwise from the top left corner to the center. Start from 1.
 * </p>
 */
public interface Task058 {
    /**
     * This method fills the matrix of order n in the suitable spiral way.
     * @param n order of matrix.
     * @return filled 2-d array or matrix.
     */
    int[][] fillSpiral(int n);
}
