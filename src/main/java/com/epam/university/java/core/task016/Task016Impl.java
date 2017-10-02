package com.epam.university.java.core.task016;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Александр on 25.09.2017.
 * How to do that?
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
        if (radius < 0) {
            throw new IllegalArgumentException();
        }

        //to square scale
        radius = radius * 2;

        Set<Coordinate> result = new HashSet<>();
        for (int i = -radius; i <= radius; i++) {
            for (int j = -radius; j <= radius; j++) {
                if (((Math.pow(i, 2) + Math.pow(j, 2)) <= Math.pow(radius, 2))
                    && (i != 0) && (j != 0)) {
                    result.add(new CoordinateImpl(i, j));
                }
            }
        }
        return result;
    }
}
