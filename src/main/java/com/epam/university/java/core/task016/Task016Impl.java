package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;

public class Task016Impl implements Task016 {

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {

        if (radius < 0.71) {
            throw new IllegalArgumentException();
        }

        Collection<Coordinate> list = new ArrayList<>();
        int x = 1;
        int y = 1;

        for (int i = y; isInCircle(i, 1, radius); i++) {
            for (int j = x; isInCircle(i, j, radius); j++) {
                list.add(new CoordinateImpl(j, i));
                list.add(new CoordinateImpl(-j, i));
                list.add(new CoordinateImpl(j, -i));
                list.add(new CoordinateImpl(-j, -i));
            }
        }


        return list;
    }

    private boolean isInCircle(int y, int x, int radius) {
        return Math.pow(y, 2) + Math.pow(x, 2) <= Math.pow(radius * 2, 2);
    }
}
