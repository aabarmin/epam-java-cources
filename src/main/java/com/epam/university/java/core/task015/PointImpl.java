package com.epam.university.java.core.task015;

public class PointImpl extends java.awt.Point implements Point {
    private double x;
    private double y;

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
}
