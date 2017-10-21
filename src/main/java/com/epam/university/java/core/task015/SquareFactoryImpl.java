package com.epam.university.java.core.task015;

public class SquareFactoryImpl implements SquareFactory {
    @Override
    public Square newInstance(Point first, Point second) {
        return new SquareImpl(first, second);
    }
}
