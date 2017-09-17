package com.epam.university.java.core.task015;

/**
 * Created by ilya on 16.09.17.
 */
public class PointImpl implements Point {

    private int coordX;
    private int coordY;

    public PointImpl(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    @Override
    public int getX() {
        return coordX;
    }

    @Override
    public void setX(int x) {
        coordX = x;
    }

    @Override
    public int getY() {
        return coordY;
    }

    @Override
    public void setY(int y) {
        coordY = y;
    }
}
