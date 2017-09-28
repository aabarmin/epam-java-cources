package com.epam.university.java.core.task019;

/**
 * Implementation class for Robot.
 *
 * @author Sergei Titov
 */
public class RobotImpl implements Robot {

    // default orientation is "to the right"
    private int deltaX = 1;
    private int deltaY = 0;

    RobotPositionImpl position = new RobotPositionImpl();

    /**
     * {@inheritDoc}
     */
    @Override
    public RobotPosition getPosition() {
        return position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(RobotPosition position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void invokeAction(RobotCommand command) {

        // change position
        if (RobotCommand.MOVE_FORWARD == command) {
            // old position
            RobotPosition position = getPosition();
            int abscissa = position.getX();
            int ordinate = position.getY();
            // new position
            position.setX(abscissa + deltaX);
            position.setY(ordinate + deltaY);
            return;
        }

        // calculate rotation sign
        int direction = 1;
        if (RobotCommand.TURN_RIGHT == command) {
            direction = -1;
        }

        // change orientation accordingly to rotation sign
        if (0 == deltaY) {
            deltaY = deltaX * direction;
            deltaX = 0;
        } else {
            deltaX = deltaY * direction * (-1);
            deltaY = 0;
        }
    }
}
