package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@inheritDoc}
 */
public class Task016Impl implements Task016 {
    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        final int distance = radius * 2;
        final Collection<Coordinate> coordinates = new ArrayList<>();
        for (int y = distance - 1; y >= 1; y--) {
            for (int x = 1; x < distance; x++) {
                double checkedDist = Math.sqrt(Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
                if (checkedDist < distance) {
                    coordinates.add(new CoordinateFactoryImpl().newInstance(x, y));
                    coordinates.add(new CoordinateFactoryImpl().newInstance(x, -y));
                    coordinates.add(new CoordinateFactoryImpl().newInstance(-x, y));
                    coordinates.add(new CoordinateFactoryImpl().newInstance(-x, -y));
                }
            }
        }

        return coordinates;
    }
}
