package com.epam.university.java.core.task016;

/**
 * Created by ilya on 21.09.17.
 */
public class CoordinateImpl implements Coordinate {

    private int coordX;
    private int coordY;

    public CoordinateImpl(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public int getX() {
        return coordX;
    }

    @Override
    public void setX(int x) {
        coordX = x;
    }

    @Override
    public int getY() {
        return coordY;
    }

    @Override
    public void setY(int y) {
        coordY = y;
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

        if (coordX != that.coordX) {
            return false;
        }
        return coordY == that.coordY;
    }

    @Override
    public int hashCode() {
        int result = coordX;
        result = 31 * result + coordY;
        return result;
    }
}
