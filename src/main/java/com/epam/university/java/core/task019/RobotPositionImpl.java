package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {
    private int coordX;
    private int coordY;

    @Override
    public int getX() {
        return coordX;
    }

    @Override
    public int getY() {
        return coordY;
    }

    @Override
    public void setX(int x) {
        coordX = x;
    }

    @Override
    public void setY(int y) {
        coordY = y;
    }
}