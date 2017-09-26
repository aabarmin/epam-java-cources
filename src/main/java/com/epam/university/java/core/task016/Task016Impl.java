package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation class for Task016.
 *
 * @author Sergei Titov
 */
public class Task016Impl implements Task016 {

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) throws IllegalArgumentException {

        if (radius < 0) {
            throw new IllegalArgumentException();
        }

        int radius2 = (radius + radius) * (radius + radius);
        List<Coordinate> list = new ArrayList<>();

        for (int x = 1; x < radius2; x++) {
            for (int y = 1; y <= radius2; y++) {
                if (x * x + y * y <= radius2) {
                    list.add(new CoordinateImpl(x, y));
                    list.add(new CoordinateImpl(-x, y));
                    list.add(new CoordinateImpl(x, -y));
                    list.add(new CoordinateImpl(-x, -y));
                }
            }
        }

        return list;
    }
}
