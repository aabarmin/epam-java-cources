package com.epam.university.java.core.task019;

import org.apache.commons.lang3.ArrayUtils;

public class RobotImpl implements Robot {
    private RobotPosition robotPosition = new RobotPositionImpl();
    private int currentOrientation = 0;
    private int prevOrientation = 0;
    private int[] loop = {360,-360};

    @Override
    public RobotPosition getPosition() {
        return robotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.robotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        if (ArrayUtils.contains(loop, currentOrientation)
                || ArrayUtils.contains(loop, prevOrientation)) {
            currentOrientation = 0;
            prevOrientation = 0;
        }
        switch (command) {
            case MOVE_FORWARD:
                invoke(currentOrientation);
                setPosition(robotPosition);
                prevOrientation = currentOrientation;
                changeOrientation("forward");
                break;

            case TURN_RIGHT:
                changeOrientation("right");
                break;

            case TURN_LEFT:
                changeOrientation("left");
                break;

            default:
                System.out.println("Error");
        }
    }

    private void changeOrientation(String orientation) {
        switch (orientation) {

            case "right":
                currentOrientation = (prevOrientation + 90);
                prevOrientation = currentOrientation;
                break;

            case "left":
                currentOrientation = (prevOrientation - 90);
                prevOrientation = currentOrientation;
                break;

            case "forward":
                currentOrientation = prevOrientation;
                break;

            default:
                System.out.println("Error");
        }
    }

    private void invoke(int currentOrientation) {
        switch (currentOrientation) {
            case 0:
                robotPosition.setY(robotPosition.getY() + 1);
                break;

            case 90:
                robotPosition.setX(robotPosition.getX() + 1);
                break;

            case 180:
                robotPosition.setY(robotPosition.getY() - 1);
                break;

            case 270:
                robotPosition.setX(robotPosition.getX() - 1);
                break;

            case -90:
                robotPosition.setX(robotPosition.getX() - 1);
                break;

            case -180:
                robotPosition.setY(robotPosition.getY() - 1);
                break;

            case -270:
                robotPosition.setX(robotPosition.getX() + 1);
                break;

            default:
                System.out.println("Error");

        }
    }
}
