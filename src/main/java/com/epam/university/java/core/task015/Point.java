package com.epam.university.java.core.task015;

/**
 * Point in 2-dimensional area.
 */
public interface Point<T>  {
    /**
     * Get x value of point.
     * @return value
     */
    T getX();

    /**
     * Get y value of point.
     * @return value
     */
    T getY();

    /**
     * Set x value of point.
     * @param x value
     */
    void setX(T x);

    /**
     * Set y value of point.
     * @param y value
     */
    void setY(T y);
}
