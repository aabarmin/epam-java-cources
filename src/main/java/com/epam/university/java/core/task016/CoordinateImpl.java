package com.epam.university.java.core.task016;

/**
 * Created by Daniil Smirnov on 21.09.2017.
 * All copy registered MF.
 */
public class CoordinateImpl implements Coordinate {

    private int pointX;
    private int pointY;

    public CoordinateImpl(int x, int y) {
        this.pointX = x;
        this.pointY = y;
    }

    @Override
    public int getX() {
        return pointX;
    }

    @Override
    public void setX(int pointX) {
        this.pointX = pointX;
    }

    @Override
    public int getY() {
        return pointY;
    }

    @Override
    public void setY(int pointY) {
        this.pointY = pointY;
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

        if (pointX != that.pointX) {
            return false;
        }
        return pointY == that.pointY;
    }

    @Override
    public int hashCode() {
        int result = pointX;
        result = 31 * result + pointY;
        return result;
    }
}
