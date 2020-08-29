package com.epam.university.java.core.task019;

import java.util.Objects;

public class RobotPositionImpl implements RobotPosition {
    private int x;
    private int y;

    public RobotPositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RobotPositionImpl)) {
            return false;
        }
        RobotPositionImpl that = (RobotPositionImpl) o;
        return getX() == that.getX()
                && getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
