package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task016Impl implements Task016 {

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius < 1) {
            throw new IllegalArgumentException();
        }
        int radForSquare = radius * 2;
        CoordinateFactoryImpl factory = new CoordinateFactoryImpl();
        List<Coordinate> part1 = new ArrayList<>();
        int first = radForSquare;
        int second = radForSquare;

        while (first != 0) {
            for (; second > 0; second--) {
                int finalRight = second;
                part1.addAll(IntStream.rangeClosed(-first, second)
                                      .filter(i -> i != 0)
                                      .mapToObj(i -> factory.newInstance(i, -finalRight))
                                      .collect(Collectors.toList()));
                part1.addAll(IntStream.rangeClosed(-first, second)
                                      .filter(i -> i != 0)
                                      .mapToObj(i -> factory.newInstance(i, finalRight))
                                      .collect(Collectors.toList()));
                part1.addAll(IntStream.rangeClosed(-second, first)
                                      .filter(i -> i != 0)
                                      .mapToObj(i -> factory.newInstance(i, -finalRight))
                                      .collect(Collectors.toList()));
                part1.addAll(IntStream.rangeClosed(-second, first)
                                      .filter(i -> i != 0)
                                      .mapToObj(i -> factory.newInstance(i, finalRight))
                                      .collect(Collectors.toList()));
            }
            first--;
        }

        return part1.stream()
                    .distinct()
                    .filter(i -> Math.sqrt(
                            Math.pow(-i.getX(), 2)
                                    + Math.pow(
                                    -i.getY(), 2))
                            < radForSquare)
                    .collect(Collectors.toList());
    }
}
