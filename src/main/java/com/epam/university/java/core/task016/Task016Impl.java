package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class Task016Impl implements Task016 {
    /**
     * Given a 2-dimensional system of coordinates. There is a circle with
     * center in (0, 0) point. You should return coordinates of squares with side of 0.5
     * which fully inside the circle.
     *
     * <p>
     * Example: radius is 1 and only points (1, 1), (-1, 1), (-1, -1) and (1, -1) inside.
     * Tip: here we have two scales - one for circle and one for squares. 0.5 in circle
     * equals to 1 in square scale. It was made to simplify presentation.
     * </p>
     *
     * @param radius radius of circle
     * @return collection square coordinates
     */
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        List<Coordinate> coordinates = new ArrayList<>();
        for (int x = -2 * radius; x <= 2 * radius; x++) {
            for (int y = -2 * radius; y <= 2 * radius; y++) {
                if (x == 0 || y == 0) {
                    continue;
                }
                // x / 2 and y / 2 to scale square coordinates to circle ones
                if (Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(2 * radius, 2)) {
                    coordinates.add(new CoordinateImpl(x, y));
                }
            }
        }
        return coordinates;
    }
}
