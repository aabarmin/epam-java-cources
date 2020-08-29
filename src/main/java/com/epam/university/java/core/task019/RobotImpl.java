package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition position;
    private RobotPosition startPosition;
    private String direction = "up";

    public RobotImpl() {
        position = new RobotPositionImpl(0,0);
        startPosition = new RobotPositionImpl(0,0);
    }

    public RobotPosition getStartPosition() {
        return startPosition;
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
            case MOVE_FORWARD: {
                switch (direction) {
                    case "up": {
                        moveUp();
                        break;
                    }
                    case "down": {
                        moveDown();
                        break;
                    }
                    case "left": {
                        moveLeft();
                        break;
                    }
                    case "right": {
                        moveRight();
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException();
                    }
                }
                break;
            }
            case TURN_LEFT:
            case TURN_RIGHT: {
                changeDirectionTurn(command);
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
    }

    private void changeDirectionTurn(RobotCommand command) {
        switch (direction) {
            case "up": {
                if (command.equals(RobotCommand.TURN_RIGHT)) {
                    direction = "right";
                } else if (command.equals(RobotCommand.TURN_LEFT)) {
                    direction = "left";
                }
                break;
            }
            case "down": {
                if (command.equals(RobotCommand.TURN_RIGHT)) {
                    direction = "left";
                } else if (command.equals(RobotCommand.TURN_LEFT)) {
                    direction = "right";
                }
                break;
            }
            case "left": {
                if (command.equals(RobotCommand.TURN_RIGHT)) {
                    direction = "up";
                } else if (command.equals(RobotCommand.TURN_LEFT)) {
                    direction = "down";
                }
                break;
            }
            case "right": {
                if (command.equals(RobotCommand.TURN_LEFT)) {
                    direction = "up";
                } else if (command.equals(RobotCommand.TURN_RIGHT)) {
                    direction = "down";
                }
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
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
