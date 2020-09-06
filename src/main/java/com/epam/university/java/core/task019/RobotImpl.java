package com.epam.university.java.core.task019;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class RobotImpl implements Robot {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public RobotPosition getPosition() {
        return new RobotPositionImpl(x, y);
    }

    @Override
    public void setPosition(RobotPosition position) {
        x = position.getX();
        y = position.getY();
    }

    @Override
    public void invokeAction(RobotCommand command) {
        String theCommand = command.name();
        switch (theCommand) {
            case "MOVE_FORWARD":
                int tempY = getY();
                tempY++;
                setY(tempY);
                break;
            case "TURN_RIGHT":
                int tempX = getX();
                tempX++;
                setX(tempX);
                break;
            default:
        }
    }
}
