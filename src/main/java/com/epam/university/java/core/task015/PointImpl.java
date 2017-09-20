package com.epam.university.java.core.task015;

/**
 * Point in 2-dimensional area.
 */
public class PointImpl implements Point {

    private final double coordX;
    private final double coordY;

    public PointImpl(double x, double y) {
        coordX = x;
        coordY = y;
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

        return coordX == point.coordX && coordY == point.coordY;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(coordX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

}
