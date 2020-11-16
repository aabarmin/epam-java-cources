package com.epam.university.java.core.task067;

/**
 * Knight attack.
 */

public interface Task067 {
    /**
     * <p>
     * The Chess Knight.
     * You will be given the location of a knight, and an end location.
     * The knight can move in a "L" shape.
     * "L" shape movement means that the knight can change it's x coordinate
     * by 2 and it's y coordinate by 1
     * or it can change it's y coordinate by 2 and it's x coordinate by 1.
     *
     * For example, if the knight is at the position (0, 0), it can move to:
     * (1,2), (1,-2), (2,1), (2,-1), (-1,2), (-1,-2), (-2,1), (-2, -1)
     *
     * Return the least amount of steps needed to go from
     * the position START (x1, y1) to END (x2, y2).
     *
     *
     * Examples
     *
     * (x1, y1, x2, y2) -> result
     *
     * (1, 1, 8, 8) -> 6
     * (1, 1, 3, 2) -> 1
     * (8, 8, 3, 3) -> 4
     *
     * </p>
     *
     * @param x1 y start position int
     * @param y1 x start position int
     * @param x2 y end position int
     * @param y2 x end position int
     * @return int -  least amount of steps needed to go from (x1, y1) to (x2, y2).
     */

    int knightMovements(int x1, int y1, int x2, int y2);
}

