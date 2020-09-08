package com.epam.university.java.core.task019;

/**
 * Created by Romin Nuro on 08.09.2020 12:59.
 */
public class RobotImpl implements Robot {

    private RobotPosition position;
    private int rotation;

    public RobotImpl() {
        position = new RobotPositionImpl(0,0);
        rotation = 0;
    }

    /**
     * Get current robot position.
     *
     * @return position
     */
    @Override
    public RobotPosition getPosition() {
        return this.position;
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
        switch (command) {
            case TURN_LEFT: {
                rotation = (rotation - 1) % 4;
                break;
            }
            case TURN_RIGHT: {
                rotation = (rotation + 1) % 4;
                break;
            }
            case MOVE_FORWARD: {
                switch (rotation) {
                    case 0: {
                        position.setY(position.getY() + 1);
                        break;
                    }
                    case 1: {
                        position.setX(position.getX() + 1);
                        break;
                    }
                    case 2: {
                        position.setY(position.getY() - 1);
                        break;
                    }
                    case 3: {
                        position.setX(position.getX() - 1);
                        break;
                    }
                    default: {
                    }
                }
                break;
            }
            default: {
            };
        }
    }
}
