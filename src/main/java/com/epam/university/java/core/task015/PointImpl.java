package com.epam.university.java.core.task015;

import java.util.Objects;

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

        if (x != point.getX()) {
            return false;
        }

        if (y != point.getY()) {
            return false;
        }
        return true;

        //return Double.compare(point.x, x) == 0
        //        && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;

        result = (int) (x + y);
        return result;
        // return Objects.hash(x,y);
    }
}
