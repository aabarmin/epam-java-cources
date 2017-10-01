package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Вера on 24.09.2017.
 */
public class Task016Impl implements Task016 {
    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {

        if (radius < 0) {
            throw new IllegalArgumentException();
        }
        Collection<Coordinate> coordinatesFirstFourth = new HashSet<>();

        for (int i = 1; i < 2 * radius; i++) {
            for (int j = 1; j < 2 * radius; j++) {
                CoordinateImpl coordinate = new CoordinateImpl();
                coordinate.setX(i);
                coordinate.setY(j);
                if (i * i + j * j < (2 * radius) * (2 * radius)) {
                    coordinatesFirstFourth.add(coordinate);
                }
            }
        }

        Collection<Coordinate> coordinates = new HashSet<>();

        for (Coordinate c : coordinatesFirstFourth) {
            // координаты квадрата для второй четверти
            CoordinateImpl coordinate2 = new CoordinateImpl();
            coordinate2.setX(- c.getX());
            coordinate2.setY(c.getY());

            // координаты квадрата для третей четверти
            CoordinateImpl coordinate3 = new CoordinateImpl();
            coordinate3.setX(- c.getX());
            coordinate3.setY(- c.getY());

            // координы квадрата для четвертой четверти
            CoordinateImpl coordinate4 = new CoordinateImpl();
            coordinate4.setX(c.getX());
            coordinate4.setY(- c.getY());

            coordinates.add(c);
            coordinates.add(coordinate2);
            coordinates.add(coordinate3);
            coordinates.add(coordinate4);
        }

        return coordinates;
    }
}
