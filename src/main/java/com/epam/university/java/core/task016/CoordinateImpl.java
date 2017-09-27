package com.epam.university.java.core.task016;

import java.util.Objects;

/**
 * Square coordinate.
 */
public class CoordinateImpl implements Coordinate {

    private int x;
    private int y;

    public CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CoordinateImpl(Coordinate coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }

    /**

     * Get x coordinate value.
     *
     * @return coordinate value
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Set x coordinate value.
     *
     * @param x coordinate value
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get y coordinate value.
     *
     * @return coordinate value
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Set y coordinate value.
     *
     * @param y coordinate value
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CoordinateImpl that = (CoordinateImpl) o;
        return x == that.x && y == that.y;

    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "{x=" + x + ", y=" + y + '}';
    }
}
