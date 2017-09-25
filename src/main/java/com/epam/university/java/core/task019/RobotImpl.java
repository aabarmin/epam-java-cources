package com.epam.university.java.core.task019;

/**
 * Created by Daniil Smirnov on 22.09.2017.
 * All copy registered MF.
 */
public class RobotImpl implements Robot {

    private int direction = 1;
    private RobotPosition rb;

    public RobotImpl() {
        rb = new RobotPositionImpl();
    }

    @Override
    public RobotPosition getPosition() {
        return rb;
    }

    @Override
    public void setPosition(RobotPosition position) {
        rb = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        if (RobotCommand.MOVE_FORWARD == command) {
            switch (direction) {
                case 1:
                    rb.setPointX(rb.getPointX() + 1);
                    break;
                case 2:
                    rb.setPointY(rb.getPointY() + 1);
                    break;
                case 3:
                    rb.setPointX(rb.getPointX() - 1);
                    break;
                case 4:
                    rb.setPointY(rb.getPointY() - 1);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (RobotCommand.TURN_LEFT == command) {
            direction++;
            boardsOfDirection();
        } else if (RobotCommand.TURN_RIGHT == command) {
            direction--;
            boardsOfDirection();
        }

    }

    private void boardsOfDirection() {

        if (direction > 4) {
            direction = 1;
        } else if (direction < 1) {
            direction = 4;
        }
    }
}
