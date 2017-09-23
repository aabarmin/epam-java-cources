package com.epam.university.java.core.task019;

/**
 * {@inheritDoc}
 */
public class RobotImpl implements Robot {
    private RobotPosition robotPosition = new RobotPositionImpl(0, 0);
    private int direction = 1;

    /**
     * {@inheritDoc}
     */
    @Override
    public RobotPosition getPosition() {
        return robotPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(RobotPosition position) {
        this.robotPosition = position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void invokeAction(RobotCommand command) {
        int x = this.getPosition().getX();
        int y = this.getPosition().getY();

        switch (command) {
            case MOVE_FORWARD:
                switch (direction) {
                    case 1:
                        this.getPosition().setX(++x);
                        break;
                    case 2:
                        this.getPosition().setY(--y);
                        break;
                    case 3:
                        this.getPosition().setX(--x);
                        break;
                    case 4:
                        this.getPosition().setY(++y);
                }
                break;
            case TURN_RIGHT:
                if (direction == 4) {
                    direction = 1;
                } else {
                    direction++;
                }
                break;
            case TURN_LEFT:
                if (direction == 1) {
                    direction = 4;
                } else {
                    direction--;
                }
                break;
        }
    }
}
