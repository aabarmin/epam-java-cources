package com.epam.university.java.core.task016;

import java.util.Objects;

/**
 * Created by Romin Nuro on 08.10.2020 13:15.
 */
public class CoordinateImpl implements Coordinate {
    private int x;
    private int y;

    public CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
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
        if (this == o) return true;
        if (!(o instanceof CoordinateImpl)) return false;
        CoordinateImpl that = (CoordinateImpl) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
