package com.epam.university.java.core.task015;

public class PointImpl implements Point {
    private double positionX;
    private double positionY;

    @Override
    public double getX() {
        return positionX;
    }

    @Override
    public double getY() {
        return positionY;
    }

    @Override
    public void setX(double x) {
        this.positionX = x;
    }

    @Override
    public void setY(double y) {
        this.positionY = y;
    }

    // a slight difference in position values is allowed
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PointImpl)) {
            return false;
        }

        PointImpl point = (PointImpl) o;

        return !(Math.abs(positionX - point.positionX) > 0.0000000000000001)
                && !(Math.abs(positionY - point.positionY) > 0.000000000000001);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(positionX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(positionY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
