package com.epam.university.java.core.task015;

/**
 * Implementation class for Point.
 *
 * @author Sergei Titov
 */
public class PointImpl<T extends Number> implements Point<T> {

    protected T abscissa;
    protected T ordinate;

    private boolean isLikeInner;

    /**
    * Constructor from (X, Y)-coordinates.
    *
    * @param x abscissa
    * @param y ordinate
    */
    protected PointImpl(T x, T y) {
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
     * Sets this point suspected to be inside the second squire.
     *
     * @returns true if it was already suspected before (twice is enough)
     */
    protected boolean suspectAsInner() {
        if (!isLikeInner) {
            isLikeInner = true;
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {

        // self check
        if (this == obj) {
            return true;
        }
        // null check
        if (obj == null) {
            return false;
        }
        // type check and cast
        if (getClass() != obj.getClass()) {
            return false;
        }

        final double deltaX;
        final double deltaY;
        final double epsilon = 0.000000000001;

        PointImpl to = (PointImpl) obj;

        deltaX = abscissa.doubleValue() - to.getX().doubleValue();
        deltaY = ordinate.doubleValue() - to.getY().doubleValue();

        return (deltaX < epsilon
                && deltaX > -epsilon
                && deltaY < epsilon
                && deltaY > -epsilon);
    }
}