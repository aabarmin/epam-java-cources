package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {

    private RobotPositionImpl position = new RobotPositionImpl();

    @Override
    public RobotPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.position = (RobotPositionImpl) position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        switch (command) {
            case TURN_LEFT:
                position.setAngle(position.getAngle() - 90);
                break;
            case TURN_RIGHT:
                position.setAngle(position.getAngle() + 90);
                break;
            case MOVE_FORWARD:
                if (position.getAngle() == 0) {
                    position.setX(position.getX() + 1);
                    position.setY(position.getY() + 1);
                } else if (position.getAngle() == 90) {
                    position.setX(position.getX() + 1);
                } else if (position.getAngle() == 270) {
                    position.setX(position.getX() - 1);
                } else if (position.getAngle() == 180) {
                    position.setX(position.getX() - 1);
                    position.setY(position.getY() - 1);
                }
                break;
            default:
                System.out.println("Incorrect result.");
        }
    }
}
