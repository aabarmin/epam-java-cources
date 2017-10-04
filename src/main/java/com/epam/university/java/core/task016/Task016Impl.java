package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.IntStream;

public class Task016Impl implements Task016 {
    private Collection<Coordinate> collection = new ArrayList<>();

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        } else {
            int scale = 2;
            int x = radius * scale;
            int y = radius * scale;
            int radiusInSquare = radius * scale;
            IntStream.rangeClosed(-x, x)
                    .filter(i -> i != 0)
                    .forEach(i -> {
                        IntStream.rangeClosed(-y, y)
                                .filter(j -> j != 0)
                                .filter(k -> Math.sqrt(Math.pow(k, 2) + Math.pow(i, 2))
                                        < radiusInSquare)
                                .forEach(l -> collection.add(new CoordinateImpl(i, l)));
                    });
            return collection;
        }
    }
}
