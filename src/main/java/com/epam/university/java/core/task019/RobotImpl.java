package com.epam.university.java.core.task019;

/**
 * Created by Александр on 21.09.2017.
 */
public class RobotImpl implements Robot {
    RobotPosition position = new RobotPositionImpl(0, 0);
    RobotDirection direction = RobotDirection.UP;

    /**
     * Get current robot position.
     *
     * @return position
     */
    @Override
    public RobotPosition getPosition() {
        return position;
    }

    /**
     * Set robot position.
     *
     * @param position position
     */
    @Override
    public void setPosition(RobotPosition position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    /**
     * Invoke robot command.
     *
     * @param command command to invoke
     */
    @Override
    public void invokeAction(RobotCommand command) {
        switch (command){
            case TURN_LEFT: {
                turnLeft();
                break;
            }
            case TURN_RIGHT: {
                turnRight();
                break;
            }
            case MOVE_FORWARD: {
                move();
                break;
            }

        }
    }

    /**
     * Change robot position.
     *
     */
    private void move() {
        switch (direction) {
            case UP: {
                position.setY(position.getY() - 1);
                break;
            }
            case LEFT: {
                position.setX(position.getX() - 1);
                break;
            }
            case RIGHT: {
                position.setX(position.getX() + 1);
                break;
            }
            case DOWN: {
                position.setY(position.getY() + 1);
                break;
            }
        }
    }

    /**
     * Change robot direction.
     *
     */
    private void turnLeft() {
        switch (direction) {
            case UP: {
                direction = RobotDirection.LEFT;
                break;
            }
            case LEFT: {
                direction = RobotDirection.DOWN;
                break;
            }
            case RIGHT: {
                direction = RobotDirection.UP;
                break;
            }
            case DOWN: {
                direction = RobotDirection.RIGHT;
                break;
            }
        }
    }

    /**
     * Change robot direction.
     *
     */
    private void turnRight() {
        switch (direction) {
            case UP: {
                direction = RobotDirection.RIGHT;
                break;
            }
            case LEFT: {
                direction = RobotDirection.UP;
                break;
            }
            case RIGHT: {
                direction = RobotDirection.DOWN;
                break;
            }
            case DOWN: {
                direction = RobotDirection.LEFT;
                break;
            }
        }
    }

    /**
     * Robot direction.
     */
    private enum  RobotDirection {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
}
