package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition position;
    private RobotPosition direction;

    /**
     * Default Constructor.
     */
    public RobotImpl() {
        position = new RobotPositionImpl();
        direction = new RobotPositionImpl();
        direction.setY(1);
        direction.setX(0);
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
                position.setX(position.getX() + direction.getX());
                position.setY(position.getY() + direction.getY());
                break;
            }
            case TURN_RIGHT: {
                if (direction.getX() == 0 && direction.getY() == 1) {
                    direction.setY(0);
                    direction.setX(1);
                } else if (direction.getX() == 1 && direction.getY() == 0) {
                    direction.setY(-1);
                    direction.setX(0);
                } else if (direction.getX() == 0 && direction.getY() == -1) {
                    direction.setY(0);
                    direction.setX(-1);
                } else if (direction.getX() == -1 && direction.getY() == 0) {
                    direction.setY(1);
                    direction.setX(0);
                }
                break;
            }
            case TURN_LEFT: {
                if (direction.getX() == 0 && direction.getY() == 1) {
                    direction.setY(0);
                    direction.setX(-1);
                } else if (direction.getX() == -1 && direction.getY() == 0) {
                    direction.setY(-1);
                    direction.setX(0);
                } else if (direction.getX() == 0 && direction.getY() == -1) {
                    direction.setY(0);
                    direction.setX(1);
                } else if (direction.getX() == 1 && direction.getY() == 0) {
                    direction.setY(1);
                    direction.setX(0);
                }
                break;
            }
            default: {
                System.out.println("No such command");
                break;
            }

        }


    }
}
