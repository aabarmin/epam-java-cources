package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class DoublePoint {

    private double coordX;
    private double coordY;

    public DoublePoint(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public DoublePoint(Point point) {
        this.coordX = point.getX();
        this.coordY = point.getY();
    }

    public double getX() {
        return coordX;
    }

    public void setX(double x) {
        coordX = x;
    }

    public double getY() {
        return coordY;
    }

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

        DoublePoint point = (DoublePoint) o;

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
