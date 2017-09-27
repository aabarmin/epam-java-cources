package com.epam.university.java.core.task021;

import com.epam.university.java.core.task015.Point;
import com.epam.university.java.core.task015.PointImpl;

/**
 * Created by Александр on 26.09.2017.
 */
public class Vector {
    private Point point;

    /**
     * Build 2d vector with start in first and end in second.
     * @param first start point
     * @param second end point
     */
    public Vector(Point first, Point second) {
        double x = second.getX() - first.getX();
        double y = second.getY() - first.getY();
        this.point = new PointImpl(x, y);
    }

    public Vector(double x, double y) {
        this.point = new PointImpl(x, y);
    }

    public double getX() {
        return point.getX();
    }

    public double getY() {
        return point.getY();
    }

    /**
     * Returns true if positive angle between vectors.
     * @param v - vector
     * @return true if positive angle
     */
    public boolean isRightTurn(Vector v) {
        double determinant = this.getX() * v.getY() - this.getY() * v.getX();
        return determinant > 0;
    }

}
