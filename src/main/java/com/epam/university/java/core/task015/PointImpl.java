package com.epam.university.java.core.task015;

public class PointImpl implements Point {
    private double coordinateX;
    private double coordinateY;
    private static final double DELTA = 0.000000000000001;

    @Override
    public double getX() {
        return coordinateX;
    }

    @Override
    public double getY() {
        return coordinateY;
    }

    @Override
    public void setX(double x) {
        coordinateX = x;
    }

    @Override
    public void setY(double y) {
        coordinateY = y;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point
                && ((Point) obj).getX() - coordinateX < DELTA
                && ((Point) obj).getY() - coordinateY < DELTA;
    }

    @Override
    public String toString() {
        return "x = " + coordinateX + " | y = " + coordinateY;
    }
}
