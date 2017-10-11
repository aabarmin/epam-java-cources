package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class SquareFactoryImpl implements SquareFactory {

    @Override
    public Square newInstance(Point first, Point second) {
        return new SquareImpl(first, second);
    }
}
