package com.epam.university.java.core.task015;

/**
 * Point in 2-dimensional area.
 */
public class PointImpl implements Point {

    private final int coordX;
    private final int coordY;

    public PointImpl(int x, int y) {
        coordX = x;
        coordY = y;
    }

    /**
     * Get x coordinate of the point.
     * @return x value
     */
    @Override
    public int getX() {
        return coordX;
    }

    /**
     * Get y coordinate of the point.
     * @return y value
     */
    @Override
    public int getY() {
        return coordY;
    }

    /**
     * Set x coordinate of the point.
     * @param x value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setX(int x) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * Set y coordinate of the point.
     * @param y value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setY(int y) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", coordX, coordY);
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
        int result = coordX;
        result = 31 * result + coordY;
        return result;
    }

}
