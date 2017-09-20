package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {

    private RobotPosition position;
    private RobotDirection direction;

    public RobotImpl() {
        position = new RobotPositionImpl();
        direction = RobotDirection.UP;
    }

    @Override
    public RobotPosition getPosition() {
        return new RobotPositionImpl(position);
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.position.setX(position.getX());
        this.position.setY(position.getY());
    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case TURN_LEFT:
                direction = direction.turnLeft();
                break;
            case TURN_RIGHT:
                direction = direction.turnRight();
                break;
            case MOVE_FORWARD:
                position = new RobotPositionImpl(
                    position.getX() + direction.getDx(),
                    position.getY() + direction.getDy()
                );
                break;
            default:
                throw new RuntimeException();
        }
    }

}
