package com.epam.university.java.core.task016;

public class CoordinateImpl implements Coordinate {
    private int xValue;
    private int yValue;

    public CoordinateImpl(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    @Override
    public int getX() {
        return xValue;
    }

    @Override
    public void setX(int x) {
        xValue = x;
    }

    @Override
    public int getY() {
        return yValue;
    }

    @Override
    public void setY(int y) {
        yValue = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof CoordinateImpl) {
            CoordinateImpl coordinate = (CoordinateImpl) obj;
            if (this.xValue == coordinate.xValue && this.yValue == coordinate.yValue) {
                return true;
            }
        }
        return false;
    }
}
