package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    // direction = 0 - looking up, 1 - right, 2 - down, 3 - left.
    private int direction = 0;
    private RobotPosition position;

    public RobotImpl() {
        this.position = new RobotPositionImpl();
    }

    @Override
    public void invokeAction(RobotCommand command) {
        if (command == RobotCommand.MOVE_FORWARD) {
            if (direction == 0) {
                position.setY(position.getY() + 1);
            } else if (direction == 1) {
                position.setX(position.getX() + 1);
            } else if (direction == 2) {
                position.setY(position.getY() - 1);
            } else if (direction == 3) {
                position.setX(position.getX() - 1);
            }
        } else if (command == RobotCommand.TURN_RIGHT) {
            if (direction < 3) {
                direction++;
            } else {
                direction = 0;
            }
        } else if (command == RobotCommand.TURN_LEFT) {
            if (direction > 0) {
                direction--;
            } else {
                direction = 3;
            }
        }
    }

    @Override
    public RobotPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.position = position;
    }
}
