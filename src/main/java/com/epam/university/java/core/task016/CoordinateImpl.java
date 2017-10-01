package com.epam.university.java.core.task016;

/**
 * Created by Вера on 24.09.2017.
 */
public class CoordinateImpl implements Coordinate {
    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

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
        if (y != that.y) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
