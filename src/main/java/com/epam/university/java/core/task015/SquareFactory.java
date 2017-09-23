package com.epam.university.java.core.task015;

/**
 * Square factory.
 */
public interface SquareFactory {
    /**
     * Build square of two points.
     * @param first first point
     * @param second second point
     * @return square instance
     */
    Square newInstance(Point first, Point second);
}
