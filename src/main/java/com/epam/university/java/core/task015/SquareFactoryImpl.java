package com.epam.university.java.core.task015;

import static java.lang.Math.pow;

public class SquareFactoryImpl implements SquareFactory {
    @Override
    public Square newInstance(Point first, Point second) {
        if (first == null || second == null){
            throw new IllegalArgumentException();
        }
        double x1 = first.getX();
        double y1 = first.getY();
        double x2 = second.getX();
        double y2 = second.getY();

        double diagonalLength = Math.sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
        double edgeLength = Math.sqrt((Math.pow(diagonalLength,2) / 2));

        return new SquareImpl(first, second, edgeLength);
    }
}
