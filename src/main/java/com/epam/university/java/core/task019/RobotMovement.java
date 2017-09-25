package com.epam.university.java.core.task019;

public enum RobotMovement {

    UP(0, 1),
    DOWN(0, -1),
    RIGHT(1, 0),
    LEFT(-1, 0);

    RobotMovement(int dx, int dy) {
        this.xMovement = dx;
        this.yMovement = dy;
    }

    private final int xMovement;
    private final int yMovement;

    /**
     *Get x coordinate of movement.
     */
    public int getxMovement() {
        return xMovement;
    }

    /**
     *Get x coordinate of movement.
     */
    public int getyMovement() {
        return yMovement;
    }

    /**
     * If the robot turns left.
     * @return new direction of robot's movement
     */
    public RobotMovement turnLeft() {
        switch (this) {
            case UP:
                return LEFT;
            case DOWN:
                return RIGHT;
            case LEFT:
                return DOWN;
            case RIGHT:
                return UP;
            default:
                throw new RuntimeException();
        }
    }

    /**
     *If the robot turns right.
     * @return new direction of robot's movement
     */
    public RobotMovement turnRight() {
        switch (this) {
            case UP:
                return RIGHT;
            case DOWN:
                return LEFT;
            case LEFT:
                return UP;
            case RIGHT:
                return DOWN;
            default:
                throw new RuntimeException();
        }
    }

}
