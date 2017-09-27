package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        CoordinateFactory factory = new CoordinateFactoryImpl();
        Set<Coordinate> resultList = new HashSet<Coordinate>();
        for (double i = 0.5; i < radius; i = i + 0.5) {
            for (double j = 0.5; j < radius; j = j + 0.5) {
                if (Math.sqrt(i * i + j * j) < radius) {
                    resultList.add(factory.newInstance((int) (i / 0.5), (int) (j / 0.5)));
                    resultList.add(factory.newInstance((int) (-i / 0.5), (int) (j / 0.5)));
                    resultList.add(factory.newInstance((int) (i / 0.5), (int) (-j / 0.5)));
                    resultList.add(factory.newInstance((int) (-i / 0.5), (int) (-j / 0.5)));
                }

            }

        }
        return new ArrayList<>(resultList);
    }
}
