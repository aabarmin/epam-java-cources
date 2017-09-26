package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition pos;
    private Direction dir = Direction.UP;

    public RobotImpl() {
        pos = new RobotPositionImpl(0, 0);
    }

    @Override
    public RobotPosition getPosition() {
        return pos;
    }

    @Override
    public void setPosition(RobotPosition position) {
        pos = position;

    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case MOVE_FORWARD:
                moveForward();
                break;
            case TURN_LEFT:
                turnLeft();
            case TURN_RIGHT:
                turnRight();
        }
    }

    private void turnRight() {
        switch (dir) {
            case UP:
                dir = Direction.RIGHT;
                break;
            case DOWN:
                dir = Direction.LEFT;
                break;
            case LEFT:
                dir = Direction.UP;
                break;
            case RIGHT:
                dir = Direction.DOWN;
                break;
        }
    }

    private void turnLeft() {
        switch (dir) {
            case UP:
                dir = Direction.LEFT;
                break;
            case DOWN:
                dir = Direction.RIGHT;
                break;
            case LEFT:
                dir = Direction.DOWN;
                break;
            case RIGHT:
                dir = Direction.UP;
                break;
        }
    }


    private void moveForward() {
        switch (dir) {
            case UP:
                pos = new RobotPositionImpl(pos.getX(), pos.getY() + 1);
                break;
            case DOWN:
                pos = new RobotPositionImpl(pos.getX(), pos.getY() - 1);
                break;
            case LEFT:
                pos = new RobotPositionImpl(pos.getX() - 1, pos.getY());
                break;
            case RIGHT:
                pos = new RobotPositionImpl(pos.getX() + 1, pos.getY());
                break;
        }
    }

    enum Direction {
        LEFT,
        RIGHT,
        UP,
        DOWN
    }
}
