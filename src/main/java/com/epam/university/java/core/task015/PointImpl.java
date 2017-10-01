package com.epam.university.java.core.task015;

import java.util.Objects;

/**
 * Created by Вера on 29.09.2017.
 */
public class PointImpl implements Point {
    private double x;
    private double y;

    public PointImpl() {
        this.x = 0;
        this.y = 0;
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
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PointImpl)) {
            return false;
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        PointImpl point = (PointImpl) o;

        if (Math.abs(x - point.getX()) > 0.000001) {
            return false;
        }
        if (Math.abs(y - point.getY()) > 0.000001) {
            return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        int result;

        result = (int) (x + y);
        return result;
    }

    @Override
    public String toString() {
        return "x =" + x + ", y=" + y;
    }
}
