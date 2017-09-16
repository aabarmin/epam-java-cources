package com.epam.university.java.core.task015;

/**
 * Squares and areas.
 */
public interface Task015 {
    /**
     * Get area of intersection of two squares. Squares are defined as two
     * opposite points in 2-dimensional area.
     *
     * <p>
     *     Example:
     *          square 1 = (2, 2) and (4, 4)
     *          square 2 = (3, 3) and (5, 5)
     *          area is 1 = square (3, 3) and (4, 4)
     * </p>
     * <p>
     *     Tip: paint it in the notebook.
     * </p>
     *
     * @param first first square definition
     * @param second second square definition
     * @return value of area
     */
    double getArea(Square first, Square second);
}
