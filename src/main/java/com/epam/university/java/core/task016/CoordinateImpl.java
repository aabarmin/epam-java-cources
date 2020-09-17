package com.epam.university.java.core.task016;

import java.util.Objects;

public class CoordinateImpl implements Coordinate {
    private int x;
    private int y;

    public CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
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
        if (!(o instanceof CoordinateImpl)) {
            return false;
        }
        CoordinateImpl that = (CoordinateImpl) o;
        return getX() == that.getX()
                && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
