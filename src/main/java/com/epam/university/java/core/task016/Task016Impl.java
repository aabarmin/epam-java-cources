package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ilya on 21.09.17.
 */
public class Task016Impl implements Task016 {

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }

        CoordinateFactory factory = new CoordinateFactoryImpl();
        List<Coordinate> squares = new ArrayList<>();

        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                squares.add(factory.newInstance(radius * 2 - j, radius * 2 - i));
            }
        }

        squares = squares.stream()
            .filter(c -> Math.pow(c.getX(), 2) + Math.pow(c.getY(), 2) <= Math.pow(radius * 2, 2))
            .flatMap(c ->
                Stream.of(
                    c,
                    factory.newInstance(-c.getX(), c.getY()),
                    factory.newInstance(c.getX(), -c.getY()),
                    factory.newInstance(-c.getX(), -c.getY())
                )).collect(Collectors.toList());

        return squares;
    }
}
