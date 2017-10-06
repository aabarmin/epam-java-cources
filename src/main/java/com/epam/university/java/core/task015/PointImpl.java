package com.epam.university.java.core.task015;

public class PointImpl implements Point {
    private double x;
    private double y;

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
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        PointImpl point = (PointImpl) obj;
        return (Math.abs(point.x - this.x) < 0.01) && (Math.abs(point.y - this.y) < 0.01);
    }
}
