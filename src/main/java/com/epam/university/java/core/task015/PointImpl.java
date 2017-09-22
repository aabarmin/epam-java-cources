package com.epam.university.java.core.task015;

/**
 * {@inheritDoc}
 */
public class PointImpl implements Point {
    private double x;
    private double y;

    /**
     * Create new instance of Point with designed coordinates.
     *
     * @param x coordinate X
     * @param y coordinate Y
     */
    protected PointImpl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(double x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(double y) {
        this.y = y;
    }
}
