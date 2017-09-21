package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class PointImpl implements Point {

    private double coordX;
    private double coordY;

    public PointImpl(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public double getX() {
        return coordX;
    }

    @Override
    public void setX(double x) {
        coordX = x;
    }

    @Override
    public double getY() {
        return coordY;
    }

    @Override
    public void setY(double y) {
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

        PointImpl point = (PointImpl) o;

        if (Double.compare(point.coordX, coordX) != 0) {
            return false;
        }
        return Double.compare(point.coordY, coordY) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(coordX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
