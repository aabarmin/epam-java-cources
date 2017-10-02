package com.epam.university.java.core.task016;

/**
 * Created by Александр on 25.09.2017.
 */
public class CoordinateImpl implements Coordinate {
    private int x;
    private int y;

    CoordinateImpl(int x, int y) {
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CoordinateImpl that = (CoordinateImpl) o;

        if (x != that.x) {
            return false;
        }
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
