package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    private RobotPosition position = new RobotPositionImpl(0, 0);
    private String whereTo = "u";

    /**
     * Get current robot position.
     *
     * @return position
     */
    @Override
    public RobotPosition getPosition() {
        return position;
    }

    /**
     * Set robot position.
     *
     * @param position position
     */
    @Override
    public void setPosition(RobotPosition position) {
        this.position = position;
    }

    /**
     * Invoke robot command.
     *
     * @param command command to invoke
     */
    @Override
    public void invokeAction(RobotCommand command) {
        if (command == RobotCommand.MOVE_FORWARD) {
            if (whereTo.equals("u")) {
                int x = this.position.getX();
                int y = this.position.getY() + 1;
                this.setPosition(new RobotPositionImpl(x, y));
            }
            if (whereTo.equals("r")) {
                int x = this.position.getX() + 1;
                int y = this.position.getY();
                this.setPosition(new RobotPositionImpl(x, y));
            }
            if (whereTo.equals("l")) {
                int x = this.position.getX() - 1;
                int y = this.position.getY();
                this.setPosition(new RobotPositionImpl(x, y));
            }
            if (whereTo.equals("d")) {
                int x = this.position.getX();
                int y = this.position.getY() - 1;
                this.setPosition(new RobotPositionImpl(x, y));
            }
        } else if (command == RobotCommand.TURN_LEFT) {
            if (whereTo.equals("u")) {
                whereTo = "l";
            } else if (whereTo.equals("d")) {
                whereTo = "r";
            } else if (whereTo.equals("l")) {
                whereTo = "d";
            } else if (whereTo.equals("r")) {
                whereTo = "u";
            }
        } else if (command == RobotCommand.TURN_RIGHT) {
            if (whereTo.equals("u")) {
                whereTo = "r";
            } else if (whereTo.equals("d")) {
                whereTo = "l";
            } else if (whereTo.equals("l")) {
                whereTo = "u";
            } else if (whereTo.equals("r")) {
                whereTo = "d";
            }
        }
    }
}