package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition position;
    private String robotDirection = "Up";

    public RobotImpl() {
        position = new RobotPositionImpl(0, 0);
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
            case MOVE_FORWARD:
                if (robotDirection.equals("Up")) {
                    moveUp();
                    robotDirection = "Up";
                }
                if (robotDirection.equals("Down")) {
                    moveDown();
                    robotDirection = "Down";
                }
                if (robotDirection.equals("Left")) {
                    moveLeft();
                    robotDirection = "Left";
                }
                if (robotDirection.equals("Right")) {
                    moveRight();
                    robotDirection = "Right";
                }
                break;
            case TURN_LEFT:
            case TURN_RIGHT:
                changeDirection(command);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void changeDirection(RobotCommand command) {
        switch (robotDirection) {
            case "Up":
                if (command.equals(RobotCommand.TURN_LEFT)) {
                    robotDirection = "Left";
                }
                if (command.equals(RobotCommand.TURN_RIGHT)) {
                    robotDirection = "Right";
                }
                break;
            case "Down":
                if (command.equals(RobotCommand.TURN_LEFT)) {
                    robotDirection = "Right";
                }
                if (command.equals(RobotCommand.TURN_RIGHT)) {
                    robotDirection = "Left";
                }
                break;
            case "Right":
                if (command.equals(RobotCommand.TURN_LEFT)) {
                    robotDirection = "Up";
                }
                if (command.equals(RobotCommand.TURN_RIGHT)) {
                    robotDirection = "Down";
                }
                break;
            case "Left":
                if (command.equals(RobotCommand.TURN_LEFT)) {
                    robotDirection = "Down";
                }
                if (command.equals(RobotCommand.TURN_RIGHT)) {
                    robotDirection = "Up";
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void moveUp() {
        position.setY(position.getY() + 1);
    }

    private void moveDown() {
        position.setY(position.getY() - 1);
    }

    private void moveRight() {
        position.setX(position.getX() + 1);
    }

    private void moveLeft() {
        position.setX(position.getX() - 1);
    }
}
