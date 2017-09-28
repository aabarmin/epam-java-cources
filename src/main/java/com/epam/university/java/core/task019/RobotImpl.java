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

        // read position
        RobotPosition position = getPosition();
        int abscissa = position.getX();
        int ordinate = position.getY();

        int direction = 0;
        switch (command) {

            // change position
            case MOVE_FORWARD : {
                position.setX(abscissa + deltaX);
                position.setY(ordinate + deltaY);
                return;
            }

            // calculate rotation sign
            case TURN_LEFT : {
                direction = 1;
                break;
            }
            case TURN_RIGHT : {
                direction = -1;
                break;
            }
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
