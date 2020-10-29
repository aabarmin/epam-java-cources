package com.epam.university.java.core.task015;

public class PointImpl implements Point, Comparable<PointImpl> {

    private double x;
    private double y;

    public PointImpl() {
    }

    public PointImpl(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return (int) (31 * x + 31 * y);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }

        PointImpl point = (PointImpl) obj;

        return point.getX() == this.getX()
                && point.getY() == this.getY();
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int compareTo(PointImpl point) {
        if (this.getX() != point.getX()) {
            return (int) (this.getX() - point.getX());
        } else {
            return (int) (this.getY() - point.getY() );
        }
    }
}
