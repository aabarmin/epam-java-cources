package com.epam.university.java.core.task016;

public class CoordinateImpl implements Coordinate {
    private int x;
    private int y;

    CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        CoordinateImpl edge = (CoordinateImpl) obj;
        return (x == edge.x && y == edge.y);
    }
}
