package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {
    private int xValue;
    private int yValue;

    @Override
    public int getX() {
        return xValue;
    }

    @Override
    public int getY() {
        return yValue;
    }

    @Override
    public void setX(int x) {
        xValue = x;

    }

    @Override
    public void setY(int y) {
        yValue = y;
    }
}
