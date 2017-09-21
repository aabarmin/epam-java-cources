package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {

    private Direction direction = Direction.NORTH;
    private RobotPosition robotPosition = new RobotPositionImpl();

    /**
     * Get current robot position.
     *
     * @return position
     */
    @Override
    public RobotPosition getPosition() {
        return robotPosition;
    }

    /**
     * Set robot position.
     *
     * @param position position
     */
    @Override
    public void setPosition(RobotPosition position) {
        this.robotPosition = position;
    }

    /**
     * Invoke robot command.
     *
     * @param command command to invoke
     */
    @Override
    public void invokeAction(RobotCommand command) {

        if (command == RobotCommand.TURN_LEFT) {

            if (direction == Direction.NORTH) {
                direction = Direction.WEST;
            } else if (direction == Direction.WEST) {
                direction = Direction.SOUTH;
            } else if (direction == Direction.SOUTH) {
                direction = Direction.EAST;
            } else if (direction == Direction.EAST) {
                direction = Direction.NORTH;
            }

        } else if (command == RobotCommand.TURN_RIGHT) {

            if (direction == Direction.NORTH) {
                direction = Direction.EAST;
            } else if (direction == Direction.EAST) {
                direction = Direction.SOUTH;
            } else if (direction == Direction.SOUTH) {
                direction = Direction.WEST;
            } else if (direction == Direction.WEST) {
                direction = Direction.NORTH;
            }

        } else if (command == RobotCommand.MOVE_FORWARD) {

            if (direction == Direction.NORTH) {
                robotPosition.setY(robotPosition.getY() + 1);
            } else if (direction == Direction.WEST) {
                robotPosition.setX(robotPosition.getX() - 1);
            } else if (direction == Direction.SOUTH) {
                robotPosition.setY(robotPosition.getY() - 1);
            } else if (direction == Direction.EAST) {
                robotPosition.setX(robotPosition.getX() + 1);
            }

        }

    }
}

enum Direction {
    NORTH,
    WEST,
    SOUTH,
    EAST
}
