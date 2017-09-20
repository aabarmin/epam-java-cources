package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;

public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }
        
        CoordinateFactoryImpl coordinateFactory = new CoordinateFactoryImpl();
        Collection<Coordinate> collection = new ArrayList<>();

        // if x^2 + y^2 < radius^2 - point is in the circle
        for (int x = 1; x < radius * 2; x++) {
            for (int y = 1; y < radius * 2; y++) {
                if ((x * x) + (y * y) < radius * radius * 4) {
                    collection.add(coordinateFactory.newInstance(x, y));
                    collection.add(coordinateFactory.newInstance(x, -y));
                    collection.add(coordinateFactory.newInstance(-x, y));
                    collection.add(coordinateFactory.newInstance(-x, -y));
                }
            }
        }

        return collection;
    }
}
