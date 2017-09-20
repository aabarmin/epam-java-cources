package com.epam.university.java.core.task015;

/**
 * Implementation class for Point.
 *
 * @author Sergei Titov
 */
public class PointImpl<T> implements Point<T> {

    T x;
    T y;

    boolean islikeInner;

     /**
     * Constructor from (X, Y)-coordinates.
     *
     * @param x
     * @param y
     */
    PointImpl(T x, T y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Get x value of point.
     *
     * @return value
     */
    @Override
    public T getX() {
        return x;
    }

    /**
     * Get y value of point.
     *
     * @return value
     */
    @Override
    public T getY() {
        return y;
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

    @Override
    public boolean suspectAsInner() {
        if (false == islikeInner) {
            islikeInner = true;
            return false;
        }
        return true;
    }
}
