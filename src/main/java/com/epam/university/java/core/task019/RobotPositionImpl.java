package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {
    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        RobotPositionImpl robotPosition = (RobotPositionImpl) obj;
        return (robotPosition.x == this.x) && (robotPosition.y == this.y);
    }
}
