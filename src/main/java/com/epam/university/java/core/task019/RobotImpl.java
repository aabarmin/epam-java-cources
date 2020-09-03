package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    @Override
    public RobotPosition getPosition() {
        return null;
    }

    @Override
    public void setPosition(RobotPosition position) {
        RobotPositionImpl robotPosition = new RobotPositionImpl(position.getX(), position.getY());
    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case MOVE_FORWARD:
                break;
            case TURN_LEFT:
                break;
            case TURN_RIGHT:
                break;
            default:
                break;
        }
    }
}
