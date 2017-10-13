package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {
    private int positionX;
    private int positionY;

    @Override
    public int getX() {
        return positionX;
    }

    @Override
    public int getY() {
        return positionY;
    }

    @Override
    public void setX(int x) {
        positionX = x;
    }

    @Override
    public void setY(int y) {
        positionY = y;
    }
}
