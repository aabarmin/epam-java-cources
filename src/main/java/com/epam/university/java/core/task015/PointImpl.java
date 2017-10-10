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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointImpl point = (PointImpl) o;

        if (point.x - x > 0.0000000001) return false;

        return point.y - y < 0.0000000001;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
