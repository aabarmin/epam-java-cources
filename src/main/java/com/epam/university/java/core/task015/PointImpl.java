package com.epam.university.java.core.task015;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Point in 2-dimensional area.
 */
public class PointImpl implements Point {

    private static final DecimalFormat formatter;

    static {
        formatter = new DecimalFormat("#.###############"); // 15 digits precision
        formatter.setRoundingMode(RoundingMode.HALF_UP);
    }

    private final double coordX;
    private final double coordY;

    public PointImpl(double x, double y) {
        coordX = x + 0.0D; // workaround for case when x is negative zero
        coordY = y + 0.0D; // ¯\_(ツ)_/¯
    }

    /**
     * Get x coordinate of the point.
     * @return x value
     */
    @Override
    public double getX() {
        return coordX;
    }

    /**
     * Get y coordinate of the point.
     * @return y value
     */
    @Override
    public double getY() {
        return coordY;
    }

    /**
     * Set x coordinate of the point.
     * @param x value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setX(double x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Set y coordinate of the point.
     * @param y value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setY(double y) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("[%f, %f]", coordX, coordY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PointImpl point = (PointImpl) o;

        return formatter.format(coordX).equals(formatter.format(point.coordX))
            && formatter.format(coordY).equals(formatter.format(point.coordY));
    }

    @Override
    public int hashCode() {
        int result = formatter.format(coordX).hashCode();
        result = 31 * result + formatter.format(coordY).hashCode();
        return result;
    }
}
