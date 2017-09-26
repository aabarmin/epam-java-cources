package com.epam.university.java.core.task016;

public class CoordinateImpl implements Coordinate {
    private int xcoord;
    private int ycoord;

    @Override
    public int getX() {
        return 0;
    }

    CoordinateImpl(int xcoord, int ycoord) {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
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

        return xcoord == that.xcoord && ycoord == that.ycoord;
    }

    @Override
    public int hashCode() {
        int result = xcoord;
        result = 31 * result + ycoord;
        return result;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

    }
}
