package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {
    private int xpos;
    private int ypos;

    RobotPositionImpl(int x, int y) {
        xpos = x;
        ypos = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RobotPositionImpl that = (RobotPositionImpl) o;

        return xpos == that.xpos && ypos == that.ypos;
    }

    @Override
    public int hashCode() {
        int result = xpos;
        result = 31 * result + ypos;
        return result;
    }

    @Override

    public int getX() {
        return xpos;
    }

    @Override
    public int getY() {
        return ypos;
    }

    @Override
    public void setX(int x) {
        xpos = x;

    }

    @Override
    public void setY(int y) {
        ypos = y;
    }
}
