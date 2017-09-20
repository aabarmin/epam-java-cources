package com.epam.university.java.core.task019;

/**
 * Direction of the Robot in 2D space.
 */
public enum RobotDirection {

    UP(0, 1),
    DOWN(0, -1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    RobotDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    private final int dx;
    private final int dy;

    /**
     * Get horizontal delta value.
     * @return dx value
     */
    public int getDx() {
        return dx;
    }

    /**
     * Get vertical delta value.
     * @return dx value
     */
    public int getDy() {
        return dy;
    }

    /**
     * Get direction after turn left.
     * @return new direction value
     */
    public RobotDirection turnLeft() {
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
     * Get direction after turn right.
     * @return new direction value
     */
    public RobotDirection turnRight() {
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
