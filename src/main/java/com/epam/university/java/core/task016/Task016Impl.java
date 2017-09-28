package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Daniil Smirnov on 21.09.2017.
 * All copy registered MF.
 */
public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        Collection<Coordinate> coordinates = new ArrayList<>();
        CoordinateFactory cf = new CoordinateFactoryImpl();

        for (int x = 1; x < radius * 2; x++) {
            for (int y = 1; y < radius * 2; y++) {
                if ((x * x) + (y * y) < radius * radius * 4) {
                    coordinates.add(cf.newInstance(x, y));
                    coordinates.add(cf.newInstance(x, -y));
                    coordinates.add(cf.newInstance(-x, y));
                    coordinates.add(cf.newInstance(-x, -y));
                }
            }
        }
        return coordinates;
    }
}
