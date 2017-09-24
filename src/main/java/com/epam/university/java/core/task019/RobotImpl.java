package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private final RobotPosition startPosition = new RobotPositionImpl(0, 0);
    private RobotPosition position = new RobotPositionImpl(0, 0);
    private RobotDirection direction = RobotDirection.UP;

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
                switch (direction) {
                    case UP:
                        direction = RobotDirection.LEFT;
                        break;
                    case RIGHT:
                        direction = RobotDirection.UP;
                        break;
                    case DOWN:
                        direction = RobotDirection.RIGHT;
                        break;
                    case LEFT:
                        direction = RobotDirection.DOWN;
                        break;
                    default:
                }
                break;
            case TURN_RIGHT:
                switch (direction) {
                    case UP:
                        direction = RobotDirection.RIGHT;
                        break;
                    case RIGHT:
                        direction = RobotDirection.DOWN;
                        break;
                    case DOWN:
                        direction = RobotDirection.LEFT;
                        break;
                    case LEFT:
                        direction = RobotDirection.UP;
                        break;
                    default:
                }
                break;
            case MOVE_FORWARD:
                switch (direction) {
                    case UP:
                        position.setY(position.getY() + 1);
                        break;
                    case RIGHT:
                        position.setX(position.getX() + 1);
                        break;
                    case DOWN:
                        position.setY(position.getY() - 1);
                        break;
                    case LEFT:
                        position.setX(position.getX() - 1);
                        break;
                    default:
                }
                break;
            default:
        }
    }

    public RobotPosition getStartPosition() {
        return startPosition;
    }
}
