package com.epam.university.java.core.task016;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        Set<Coordinate> resultSet = new HashSet<>();
        int newRadius = radius * 2;

        for (int i = 0 - newRadius; i < newRadius; i++) {
            for (int j = 0 - newRadius; j < newRadius; j++) {
                if ((i * i) + (j * j) <= newRadius * newRadius) {
                    int x0 =  i * (- 1);
                    int y0 = j * (- 1);

                    if (x0 != 0 && y0 != 0) {
                        resultSet.add(new CoordinateImpl(x0, y0));
                    }
                }
            }
        }

        return resultSet;
    }
}
