package com.epam.university.java.core.task015;

/**
 * Point factory.
 */
public interface PointFactory<T> {
    /**
     * Creates new point instance.
     * @param x x coordinate
     * @param y y coordinate
     * @return point instance
     */
    Point newInstance(T x, T y);
}
