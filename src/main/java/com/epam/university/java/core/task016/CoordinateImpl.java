package com.epam.university.java.core.task016;

public class CoordinateImpl implements Coordinate {

    private final int abscissa;
    private final int ordinate;

    public CoordinateImpl(int x, int y) {
        this.abscissa = x;
        this.ordinate = y;
    }

    @Override
    public int getX() {
        return abscissa;
    }

    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getY() {
        return ordinate;
    }

    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", abscissa, ordinate);
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

        return abscissa == that.abscissa && ordinate == that.ordinate;
    }

    @Override
    public int hashCode() {
        int result = abscissa;
        result = 39 * result + ordinate;
        return result;
    }

}
