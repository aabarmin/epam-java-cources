package com.epam.university.java.core.task019;

/**
 * Created by ilya on 21.09.17.
 */
public class RobotImpl implements Robot {

    private final RobotPosition defaultPosition = new RobotPositionImpl(0, 0);

    private ModificationMatrix matrix = new ModificationMatrix();

    private Direction direction = new Direction(0, 1);
    private RobotPosition position = defaultPosition;

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
                direction = matrix
                    .left()
                    .modify(direction);
                break;
            case TURN_RIGHT:
                direction = matrix
                    .right()
                    .modify(direction);
                break;
            case MOVE_FORWARD:
                RobotPosition newPosition = new RobotPositionImpl(
                    position.getX() + direction.getDirX(),
                    position.getY() + direction.getDirY()
                );
                setPosition(newPosition);
                break;
            default:
                break;
        }
    }

}
