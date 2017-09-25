package com.epam.university.java.core.task015;

import com.epam.university.java.core.utils.geometricprimitives.Point2D;

public class PointImpl implements Point {
    public PointImpl(double coordinateX, double coordinateY) {
        point2D = new Point2D(coordinateX, coordinateY);}

    private Point2D point2D;



    public Point2D getPoint2D() {
        return point2D;
    }

    @Override

    public double getX() {
        return (int) point2D.x();
    }

    @Override
    public double getY() {
        return (int) point2D.y();
    }

    @Override
    public void setX(double x) {
        point2D.setCoordinateX(x);
    }

    @Override
    public void setY(double y) {
        point2D.setCoordinateY(y);
    }
}