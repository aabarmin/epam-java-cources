package com.epam.university.java.core.task016;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Circle and squares.
 */
public class Task016Impl implements Task016 {

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
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        radius *= 2;
        List<Coordinate> coordinates = new LinkedList<>();
        for (int x = -radius; x <= radius; ++x) {
            for (int y = -radius; y <= radius; ++y) {
                if (isInside(x, y, radius)) {
                    coordinates.add(computeCoord(x, y));
                }
            }
        }
        return coordinates;
    }

    /**
     * Checks if a square is inside of a circle with given radius.
     * @param x x coordinate of top-left point
     * @param y y coordinate of top-left point
     * @param r radius of a circle
     * @return <code>true</code> if inside, else <code>false</code>
     */
    private boolean isInside(int x, int y, int r) {
        final double r2 = Math.pow(r, 2);
        return Math.pow(x, 2) + Math.pow(y, 2) <= r2            // top-left
            && Math.pow(x + 1, 2) + Math.pow(y, 2) <= r2        // top-right
            && Math.pow(x + 1, 2) + Math.pow(y - 1, 2) <= r2    // bottom-right
            && Math.pow(x, 2) + Math.pow(y - 1, 2) <= r2;       // bottom-left
    }

    /**
     * Translates point into another coordinate system.
     * <p>
     *     -------------------
     *     |        |        |
     *     |(-1, 1) | (1, 1) |
     *     |        |        |
     *     |------(0,0)------|
     *     |        |        |
     *     |(-1, -1)| (1, -1)|
     *     |        |        |
     *     -------------------
     * </p>
     * @param x x coordinate
     * @param y y coordinate
     * @return translated Coordinate instance
     */
    private Coordinate computeCoord(int x, int y) {
        return new CoordinateImpl(
            x < 0 ? x : x + 1,
            y > 0 ? y : y - 1
        );
    }

}
