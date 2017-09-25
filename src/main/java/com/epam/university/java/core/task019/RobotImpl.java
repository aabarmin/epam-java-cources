package com.epam.university.java.core.task019;

/**
 * Created by Вера on 25.09.2017.
 */
public class RobotImpl implements Robot {
    private int indicator = 0;
    private RobotPosition position = new RobotPositionImpl();

    public int getIndicator() {
        return indicator;
    }

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
        if (command.name().equals("TURN_RIGHT")) {
            indicator++;
        }
        if (command.name().equals("TURN_LEFT")) {
            indicator = indicator + 3;
        }

        if (command.name().equals("MOVE_FORWARD")) {
            if (indicator % 4 == 0) {
                RobotPositionImpl robotPosition = new RobotPositionImpl();
                robotPosition.setX(this.getPosition().getX());
                robotPosition.setY(this.getPosition().getY() + 1);
                this.setPosition(robotPosition);
            }
            if (indicator % 4 == 1) {
                RobotPositionImpl robotPosition = new RobotPositionImpl();
                robotPosition.setX(this.getPosition().getX() + 1);
                robotPosition.setY(this.getPosition().getY());
                this.setPosition(robotPosition);
            }
            if (indicator % 4 == 2) {
                RobotPositionImpl robotPosition = new RobotPositionImpl();
                robotPosition.setX(this.getPosition().getX());
                robotPosition.setY(this.getPosition().getY() - 1);
                this.setPosition(robotPosition);
            }
            if (indicator % 4 == 3) {
                RobotPositionImpl robotPosition = new RobotPositionImpl();
                robotPosition.setX(this.getPosition().getX() - 1);
                robotPosition.setY(this.getPosition().getY());
                this.setPosition(robotPosition);
            }
        }

    }
}
