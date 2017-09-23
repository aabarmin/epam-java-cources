package com.epam.university.java.core.task016;

import java.util.Collection;

/**
 * Circle and squares.
 */
public interface Task016 {
    /**
     * Given a 2-dimensional system of coordinates. There is a circle with
     * center in (0, 0) point. You should return coordinates of squares with side of 0.5
     * which fully inside the circle.
     *
     * <p>
     *     Example: radius is 1 and only points (1, 1), (-1, 1), (-1, -1) and (1, -1) inside.
     *     Tip: here we have two scales - one for circle and one for squares. 0.5 in circle
     *     equals to 1 in square scale. It was made to simplify presentation.
     * </p>
     *
     * @param radius radius of circle
     * @return collection square coordinates
     */
    Collection<Coordinate> getSquaresInsideCircle(int radius);
}
