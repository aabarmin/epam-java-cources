package com.epam.university.java.core.task019;

import java.util.Objects;

public class RobotPositionImpl implements RobotPosition {

    private String direction = "UP";

    private int x = 0;
    private int y = 0;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RobotPositionImpl that = (RobotPositionImpl) o;
        return x == that.x &&
                y == that.y &&
                Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, x, y);
    }
}
