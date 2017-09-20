package com.epam.university.java.core.task019;

/**
 * Robot position.
 */
public class RobotPositionImpl implements RobotPosition {

    private final int coordX;
    private final int coordY;

    public RobotPositionImpl() {
        this.coordX = 0;
        this.coordY = 0;
    }

    public RobotPositionImpl(int x, int y) {
        this.coordX = x;
        this.coordY = y;
    }

    public RobotPositionImpl(RobotPosition that) {
        this.coordX = that.getX();
        this.coordY = that.getY();
    }

    /**
     * Get x value.
     * @return value
     */
    @Override
    public int getX() {
        return coordX;
    }

    /**
     * Get y value.
     * @return value
     */
    @Override
    public int getY() {
        return coordY;
    }

    /**
     * Set x value.
     * @param x value
     * @throws UnsupportedOperationException as modifying is prohibited
     */
    @Override
    public void setX(int x) {
        throw new UnsupportedOperationException();
    }

    /**
     * Set y value.
     * @param y value
     * @throws UnsupportedOperationException as modifying is prohibited
     */
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
        RobotPositionImpl that = (RobotPositionImpl) o;
        return coordX == that.coordX && coordY == that.coordY;
    }

    @Override
    public int hashCode() {
        int result = coordX;
        result = 31 * result + coordY;
        return result;
    }
}
