package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {

    private final int abscissa;
    private final int ordinate;

    public RobotPositionImpl() {
        this.abscissa = 0;
        this.ordinate = 0;
    }

    public RobotPositionImpl(int x, int y) {
        this.abscissa = x;
        this.ordinate = y;
    }

    public RobotPositionImpl(RobotPosition position) {
        this.abscissa = position.getX();
        this.ordinate = position.getY();
    }

    @Override
    public int getX() {
        return abscissa;
    }

    @Override
    public int getY() {
        return ordinate;
    }

    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setY(int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RobotPositionImpl position = (RobotPositionImpl) o;
        return abscissa == position.abscissa && ordinate == position.ordinate;
    }

    @Override
    public int hashCode() {
        int result = abscissa;
        result = 39 * result + ordinate;
        return result;
    }
}
