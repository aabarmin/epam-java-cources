package com.epam.university.java.core.task015;

/**
 * Created by Romin Nuro on 31.08.2020 23:16.
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
        if (first == null || second == null) {
            throw new IllegalArgumentException();
        }
        return new SquareImpl(first, second);
    }
}
