package com.epam.university.java.core.task015;

public class PointImpl implements Point {

    private double pointX;
    private double pointY;

    public PointImpl(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    @Override
    public double getX() {
        return pointX;
    }

    @Override
    public double getY() {
        return pointY;
    }

    @Override
    public void setX(double x) {
        pointX = x;
    }

    @Override
    public void setY(double y) {
        pointY = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PointImpl)) {
            return false;
        }

        PointImpl point = (PointImpl) o;

        return !(Math.abs(pointX - point.pointX) > 0.0000000000000001)
                && !(Math.abs(pointY - point.pointY) > 0.000000000000001);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(pointX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(pointY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
