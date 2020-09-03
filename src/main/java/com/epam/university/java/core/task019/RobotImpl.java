package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {

    RobotPositionImpl robotPosition = new RobotPositionImpl();

    @Override
    public RobotPosition getPosition() {
        return robotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {

    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case MOVE_FORWARD:
                switch (robotPosition.getDirection()) {
                    case "UP":
                        robotPosition.setY(robotPosition.getY() + 1);
                        break;
                    case "DOWN":
                        robotPosition.setY(robotPosition.getY() - 1);
                        break;
                    case "RIGHT":
                        robotPosition.setX(robotPosition.getX() + 1);
                        break;
                    case "LEFT":
                        robotPosition.setX(robotPosition.getX() - 1);
                        break;
                }
                break;
            case TURN_LEFT:
                switch (robotPosition.getDirection()) {
                    case "UP":
                        robotPosition.setDirection("LEFT");
                        break;
                    case "DOWN":
                        robotPosition.setDirection("RIGHT");
                        break;
                    case "RIGHT":
                        robotPosition.setDirection("UP");
                        break;
                    case "LEFT":
                        robotPosition.setDirection("DOWN");
                        break;
                }
                break;
            case TURN_RIGHT:
                switch (robotPosition.getDirection()) {
                    case "UP":
                        robotPosition.setDirection("RIGHT");
                        break;
                    case "DOWN":
                        robotPosition.setDirection("LEFT");
                        break;
                    case "RIGHT":
                        robotPosition.setDirection("DOWN");
                        break;
                    case "LEFT":
                        robotPosition.setDirection("UP");
                        break;
                }
                break;
            default:
                break;
        }
    }
}
