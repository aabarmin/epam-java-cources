package com.epam.university.java.core.task019;

import com.epam.university.java.core.utils.common.Validator;
import com.epam.university.java.core.utils.geometricprimitives.Point2D;

/**
 * Class implements <code>RobotPosition</code> class.
 */
public class RobotPositionImpl implements RobotPosition {
    private Point2D position;

    /**
     * Initialisation of machine position.
     *
     * @param coordinateX coordinate x
     * @param coordinateY coordinate y
     * @throws IllegalArgumentException if at least one of parameters doesn't
     *                                  belongs to permitted range
     */
    public RobotPositionImpl(int coordinateX, int coordinateY) {
        Validator.validateValueRange(coordinateX, Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        Validator.validateValueRange(coordinateY, Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        this.position = new Point2D(coordinateX, coordinateY);
    }

    /**
     * Initialisation of <code>RobotPositionImpl</code>.
     */
    public RobotPositionImpl() {
        this.position = new Point2D(0, 0);
    }

    @Override
    public int getX() {
        return (int) position.getCoordinateX();
    }

    @Override
    public void setX(int coordinateX) {
        Validator.validateValueRange(coordinateX, Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        position.setCoordinateX(coordinateX);
    }

    @Override
    public int getY() {
        return (int) position.getCoordinateY();
    }

    @Override
    public void setY(int coordinateY) {
        Validator.validateValueRange(coordinateY, Integer.MIN_VALUE,
                Integer.MAX_VALUE,
                Validator.MESSAGE_IF_VIOLATES_LOWER_BORDER,
                Validator.MESSAGE_IF_VIOLATES_UPPER_BORDER);
        position.setCoordinateY(coordinateY);
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
}