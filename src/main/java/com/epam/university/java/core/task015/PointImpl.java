package com.epam.university.java.core.task015;

/**
 * Implementation class for Point.
 *
 * @author Sergei Titov
 */
public class PointImpl<T> implements Point<T> {

    T abscissa;
    T ordinate;

    boolean islikeInner;

    /**
    * Constructor from (X, Y)-coordinates.
    *
    * @param x abscissa
    * @param y ordinate
    */
    PointImpl(T x, T y) {
        this.abscissa = x;
        this.ordinate = y;
    }

    /**
     * Get x value of point.
     *
     * @return value
     */
    @Override
    public T getX() {
        return abscissa;
    }

    /**
     * Get y value of point.
     *
     * @return value
     */

    @Override
    public T getY() {
        return ordinate;
    }

    /**
     * Set x value of point.
     *
     * @param x value
     */
    @Override
    public void setX(T x) {
    }

    /**
     * Set y value of point.
     *
     * @param y value
     */
    @Override
    public void setY(T y) {
    }

    /**
     * Sets this point suspected to be inside the second squire
     *
     * @returns true if it was already suspected (twice is enough)
     */
    public boolean suspectAsInner() {
        if (false == islikeInner) {
            islikeInner = true;
            return false;
        }
        return true;
    }
}