package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task016Impl implements Task016 {

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Incorrect radius");
        }
        if (radius == 0) {
            return Collections.emptyList();
        }
        List<Coordinate> squares = new ArrayList<>();
        CoordinateFactory coordinate = new CoordinateFactoryImpl();
        int numSquareRadius = radius * 2;
        for (int x = 1; x < numSquareRadius; x++) {
            for (int y = 1; y < numSquareRadius; y++) {
                if (x * x + y * y < numSquareRadius * numSquareRadius) {
                    squares.add(coordinate.newInstance(x, y));
                    squares.add(coordinate.newInstance(-x, y));
                    squares.add(coordinate.newInstance(x, -y));
                    squares.add(coordinate.newInstance(-x, -y));
                }
            }
        }
        return squares;
    }
}