package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {
    private int xcoord;
    private int ycoord;

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof RobotPosition)
                && (xcoord == ((RobotPosition) obj).getX())
                && (ycoord == ((RobotPosition) obj).getY());
    }

    public RobotPositionImpl(int xcoord, int ycoord) {
        this.xcoord = xcoord;
        this.ycoord = ycoord;
    }

    @Override
    public int getX() {
        return xcoord;
    }

    @Override
    public int getY() {
        return ycoord;
    }

    @Override
    public void setX(int x) {
        xcoord = x;
    }

    @Override
    public void setY(int y) {
        ycoord = y;
    }
}
