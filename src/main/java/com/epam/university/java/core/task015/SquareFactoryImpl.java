package com.epam.university.java.core.task015;

/**
 * Implementation class for SquareFactory.
 *
 * @author Sergei Titov
 */
public class SquareFactoryImpl implements SquareFactory {
    /**
     * Build square of two points.
     *
     * @param first  first point
     * @param second second point
     * @return square instance
     */
    @Override
    public Square newInstance(Point first, Point second) {
        return new SquareImpl(first, second);
    }
}
