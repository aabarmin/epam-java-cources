package com.epam.university.java.core.task015;

/**
 * Square factory.
 */
public class SquareFactoryImpl implements SquareFactory {

    /**
     * Builds a square of two points.
     * @param first first point
     * @param second second point
     * @return square instance
     */
    @Override
    public Square newInstance(Point first, Point second) {
        return new SquareImpl(first, second);
    }

}
