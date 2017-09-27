package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition position = new RobotPositionImpl();
    private Direction direction = Direction.SOUTH;

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
                    case SOUTH:
                        direction = Direction.EAST;
                        break;
                    case NORTH:
                        direction = Direction.WEST;
                        break;
                    case WEST:
                        direction = Direction.SOUTH;
                        break;
                    case EAST:
                        direction = Direction.NORTH;
                        break;
                    default:
                        System.out.println("Incorrect direction!");
                        break;
                }
                break;
            case TURN_RIGHT:
                switch (direction) {
                    case SOUTH:
                        direction = Direction.WEST;
                        break;
                    case NORTH:
                        direction = Direction.EAST;
                        break;
                    case WEST:
                        direction = Direction.NORTH;
                        break;
                    case EAST:
                        direction = Direction.SOUTH;
                        break;
                    default:
                        System.out.println("Incorrect direction!");
                        break;
                }
                break;
            case MOVE_FORWARD:
                switch (direction) {
                    case SOUTH:
                        position.setY(position.getY() - 1);
                        break;
                    case NORTH:
                        position.setY(position.getY() + 1);
                        break;
                    case WEST:
                        position.setX(position.getX() - 1);
                        break;
                    case EAST:
                        position.setX(position.getX() + 1);
                        break;
                    default:
                        System.out.println("Incorrect direction!");
                        break;
                }
                break;
            default:
                System.out.println("Incorrect action!");
                break;
        }
    }
}