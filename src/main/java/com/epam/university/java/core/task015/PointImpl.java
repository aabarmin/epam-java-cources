package com.epam.university.java.core.task015;

import java.util.Objects;

/**
 * Point in 2-dimensional area. With 6 zero precision
 */
public class PointImpl implements Point {

    private double x;
    private double y;

    public PointImpl(double x, double y) {
        this.x = Math.round(x * 1000000) / 1000000.0;
        this.y = Math.round(y * 1000000) / 1000000.0;
    }

    /**
     * Get x value of point.
     *
     * @return value
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Get y value of point.
     *
     * @return value
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Set x value of point.
     *
     * @param x value
     */
    @Override
    public void setX(double x) {
        this.x =  Math.round(x * 1000000) / 1000000;
    }

    /**
     * Set y value of point.
     *
     * @param y value
     */
    @Override
    public void setY(double y) {
        this.y = Math.round(y * 1000000) / 1000000;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof PointImpl)) {
            return false;
        }

        PointImpl point = (PointImpl) o;
        return Double.compare(point.x, x) == 0
                && Double.compare(point.y, y) == 0;

    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + "}";
    }
}
