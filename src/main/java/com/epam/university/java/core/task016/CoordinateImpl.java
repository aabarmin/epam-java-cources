package com.epam.university.java.core.task016;

/**
 * {@inheritDoc}
 */
public class CoordinateImpl implements Coordinate {

    private int x;
    private int y;

    /**
     * Create instance with designed coordinates.
     *
     * @param x coordinate x
     * @param y coordinate y
     */
    protected CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
