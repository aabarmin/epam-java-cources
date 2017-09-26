package com.epam.university.java.core.task016;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

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

        if (radius < 0) {
            throw new IllegalArgumentException();
        }

        if (radius == 0) {
            return new ArrayList<>();
        }

        // For visualization mathway.com/graph
        // x^2 + y^2 = R^2

        int r = radius * 2;

        List<Coordinate> coordinates = new ArrayList<>();

        for (int x = 1; x < r; x++) {
            for (int y = 1; y < r; y++) {
                if (x * x + y * y <= r * r) {
                    coordinates.add(new CoordinateImpl(x, y));
                }
            }
        }

        Set<Coordinate> allCoordinates = new HashSet<>();
        allCoordinates.addAll(coordinates);

        Coordinate coordinate;

        for (Coordinate c : coordinates) {

            coordinate = new CoordinateImpl(c);
            coordinate.setY(-coordinate.getY());
            allCoordinates.add(coordinate);

            coordinate = new CoordinateImpl(c);
            coordinate.setX(-coordinate.getX());
            allCoordinates.add(coordinate);

            coordinate = new CoordinateImpl(c);
            coordinate.setX(-coordinate.getX());
            coordinate.setY(-coordinate.getY());
            allCoordinates.add(coordinate);

        }

        return allCoordinates;

    }
}
