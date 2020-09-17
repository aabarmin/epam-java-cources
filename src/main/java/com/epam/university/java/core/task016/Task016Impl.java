package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }

        int positiveSquareScale = radius * 2;
        int negativeSquareScale = -(radius * 2);
        List<Coordinate> listOfCoordinates = new ArrayList<>();

        for (int x = negativeSquareScale; x < positiveSquareScale; x++) {
            for (int y = negativeSquareScale; y < positiveSquareScale; y++) {
                if (x == 0 || y == 0) {
                    continue;
                }
                if (insideTheCircle(x, y, radius)) {
                    listOfCoordinates.add(new CoordinateImpl(x, y));
                }
            }
        }

        return listOfCoordinates;
    }

    public boolean insideTheCircle(int x, int y, int radius) {
        radius = radius * 2;
        return ((x * x + y * y) - radius * radius) <= 0;
    }
}
