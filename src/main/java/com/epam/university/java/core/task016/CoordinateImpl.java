package com.epam.university.java.core.task016;

/**
 * Square coordinate.
 */
public class CoordinateImpl implements Coordinate {

    private final int coordX;
    private final int coordY;

    public CoordinateImpl(int x, int y) {
        this.coordX = x;
        this.coordY = y;
    }

    /**
     * Get x coordinate value.
     * @return coordinate value
     */
    @Override
    public int getX() {
        return coordX;
    }

    /**
     * Set x coordinate value.
     * @param x coordinate value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException();
    }

    /**
     * Get y coordinate value.
     * @return coordinate value
     */
    @Override
    public int getY() {
        return coordY;
    }

    /**
     * Set y coordinate value.
     * @param y coordinate value
     * @throws UnsupportedOperationException as modification is forbidden
     */
    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", coordX, coordY);
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

        return coordX == that.coordX && coordY == that.coordY;
    }

    @Override
    public int hashCode() {
        int result = coordX;
        result = 31 * result + coordY;
        return result;
    }

}
