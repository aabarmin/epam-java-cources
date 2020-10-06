package com.epam.university.java.core.task016;

import java.util.ArrayList;
import java.util.Collection;

public class Task016Impl implements Task016 {

    @Override
    public Collection<Coordinate> getSquaresInsideCircle(int radius) {

        if (radius <= 0) {
            throw new IllegalArgumentException();
        }
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        Coordinate upperRightCoordinate = new CoordinateFactoryImpl()
                .newInstance(2 * radius, 2 * radius);
        Coordinate lowerLeftCoordinate = new CoordinateFactoryImpl()
                .newInstance(-2 * radius, -2 * radius);

        Coordinate currentCoordinate = new CoordinateFactoryImpl()
                .newInstance(2 * radius, 2 * radius);
        int i = 0;
        int j = 0;
        while (!currentCoordinate.equals(lowerLeftCoordinate)) {
            currentCoordinate = new CoordinateFactoryImpl().newInstance(
                    upperRightCoordinate.getX() - i,
                    upperRightCoordinate.getY() - j);
            if (currentCoordinate.getX() != 0
                    && currentCoordinate.getY() != 0
                    && pointInsideCircle(currentCoordinate, radius)) {
                coordinates.add(currentCoordinate);
            }
            ++j;
            if (currentCoordinate.getY() == lowerLeftCoordinate.getY()) {
                ++i;
                j = 0;
            }
        }
        return coordinates;
    }

    public boolean pointInsideCircle(Coordinate coordinate, int radius) {
        double length = Math.sqrt(Math.pow(coordinate.getX(), 2) + Math.pow(coordinate.getY(), 2));
        return length <= radius * 2;
    }
}

