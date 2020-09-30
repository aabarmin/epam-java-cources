package com.epam.university.java.core.task015;

/**
 * Author Dmitry Novikov 28-Sep-20.
 */
public class SquareFactoryImpl implements SquareFactory{
    @Override
    public Square newInstance(Point first, Point second) {
        if (first==null || second == null) {
            throw new IllegalArgumentException();
        }
        return new SquareImpl(first, second);
    }
}
