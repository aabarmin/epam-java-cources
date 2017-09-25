
package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Task016Impl implements Task016 {

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException();
        }

        CoordinateFactory coordinateFactory = new CoordinateFactoryImpl();
        List<Coordinate> figures = new ArrayList<>();

        for (int i = 0; i < radius * 2; i++) {
            for (int j = 0; j < radius * 2; j++) {
                figures.add(coordinateFactory.newInstance(radius * 2 - j, radius * 2 - i));
            }
        }

        Predicate<Coordinate> predicate = (n) -> {
            double a = Math.pow(n.getX(), 2) + Math.pow(n.getY(), 2);
            double b = Math.pow(radius * 2, 2);
            if (a > b) {
                return false;
            } else {
                return true;
            }
        };

        figures = figures.stream().filter(predicate).collect(Collectors.toList());

        List<Coordinate> result = new ArrayList<>();
        result.addAll(figures);
        result.addAll(figures.stream()
                .map(n -> coordinateFactory.newInstance(-n.getX(), -n.getY()))
                .collect(Collectors.toList()));
        result.addAll(figures.stream()
                .map(n -> coordinateFactory.newInstance(-n.getX(), n.getY()))
                .collect(Collectors.toList()));
        result.addAll(figures.stream()
                .map(n -> coordinateFactory.newInstance(n.getX(), -n.getY()))
                .collect(Collectors.toList()));

        return result;
    }
}
