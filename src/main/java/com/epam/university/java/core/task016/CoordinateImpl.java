package com.epam.university.java.core.task016;

public class CoordinateImpl implements Coordinate {
    private int valueX;
    private int valueY;

    @Override
    public int getX() {
        return valueX;
    }

    @Override
    public void setX(int x) {
        valueX = x;
    }

    @Override
    public int getY() {
        return valueY;
    }

    @Override
    public void setY(int y) {
        valueY = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CoordinateImpl)) {
            return false;
        }

        CoordinateImpl that = (CoordinateImpl) o;

        return valueX == that.valueX && valueY == that.valueY;
    }

    @Override
    public int hashCode() {
        int result = valueX;
        result = 31 * result + valueY;
        return result;
    }
}