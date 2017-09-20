package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class PointImpl implements Point {

    private double coordX;
    private double coordY;

    public PointImpl(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public double getX() {
        return coordX;
    }

    @Override
    public void setX(double x) {
        coordX = x;
    }

    @Override
    public double getY() {
        return coordY;
    }

    @Override
    public void setY(double y) {
        coordY = y;
    }

    @Override
    public String toString() {
        return "PointImpl{" +
            "coordX=" + coordX +
            ", coordY=" + coordY +
            '}';
    }
}
