package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {

    private RobotPosition position;
    private int direction; // 0 - UP, 1 - RIGHT, 2 - DOWN, 3 - LEFT

    public RobotImpl() {
        position = new RobotPositionImpl(0, 0);
        direction = 0;
    }

    @Override
    public RobotPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.position = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case TURN_LEFT:
                if (direction > 0) {
                    direction--;
                } else {
                    direction = 4;
                }
                break;
            case TURN_RIGHT:
                if (direction < 4) {
                    direction++;
                } else {
                    direction = 0;
                }
                break;
            case MOVE_FORWARD:
                switch (direction) {
                    case 0:
                        position.setY(position.getY() + 1);
                        break;
                    case 1:
                        position.setX(position.getX() + 1);
                        break;
                    case 2:
                        position.setY(position.getY() - 1);
                        break;
                    case 3:
                        position.setX(position.getX() - 1);
                        break;
                }
                break;
        }
    }
}
