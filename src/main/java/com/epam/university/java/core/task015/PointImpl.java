package com.epam.university.java.core.task015;

public class PointImpl implements Point {
    private double xcoord;
    private double ycoord;

    PointImpl(double x, double y) {
        this.xcoord = x;
        this.ycoord = y;
    }

    @Override
    public double getX() {
        return xcoord;
    }

    @Override
    public void setX(double x) {
        this.xcoord = x;
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

        return (Math.abs(point.xcoord - xcoord) < 0.0000000000001
                && Math.abs(point.ycoord - ycoord) < 0.000000000001);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(xcoord);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ycoord);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public double getY() {
        return ycoord;
    }

    @Override
    public void setY(double y) {
        this.ycoord = y;
    }
}
