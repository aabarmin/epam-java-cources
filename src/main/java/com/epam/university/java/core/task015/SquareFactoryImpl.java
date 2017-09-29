package com.epam.university.java.core.task015;

/**
 * Created by Александр on 22.09.2017.
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
