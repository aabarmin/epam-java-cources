package com.epam.university.java.core.task019;

import com.epam.university.java.core.utils.geometricprimitives.Point2D;

public class RobotPositionImpl implements RobotPosition {
    private Point2D position;

    public RobotPositionImpl(double coordinateX, double coordinateY) {
        this.position = new Point2D(coordinateX, coordinateY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RobotPositionImpl)) return false;

        RobotPositionImpl that = (RobotPositionImpl) o;

        return position != null ? position.equals(that.position) : that
                .position == null;
    }

    @Override
    public int hashCode() {
        return position != null ? position.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "RobotPositionImpl{" + "position=" + position + '}';
    }

    public RobotPositionImpl() {
        this.position = new Point2D(0, 0);
    }

    @Override
    public int getX() {
        return (int) position.x();
    }

    @Override
    public int getY() {
        return (int) position.y();
    }

    @Override
    public void setX(int x) {
        position.setCoordinateX(x);
    }

    @Override
    public void setY(int y) {
        position.setCoordinateY(y);
    }
}
