package com.epam.university.java.core.task015;

/**
 * Created by Вера on 29.09.2017.
 */
public class PointImpl implements Point {
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
