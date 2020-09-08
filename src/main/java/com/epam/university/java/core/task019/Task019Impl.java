package com.epam.university.java.core.task019;

/**
 * Created by Romin Nuro on 08.09.2020 13:17.
 */
public class Task019Impl implements Task019 {
    /**
     * Invoke robot command.
     *
     * @param robot   robot to work with
     * @param command command to execute
     */
    @Override
    public void invokeAction(Robot robot, RobotCommand command) {
        if (robot == null || command == null) {
            throw new IllegalArgumentException();
        }
        robot.invokeAction(command);
    }

    /**
     * Is robot now on it's start position.
     *
     * @param robot robot to check
     * @return is robot on start position
     */
    @Override
    public boolean isOnStartPosition(Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException();
        }
        RobotPosition position = robot.getPosition();
        return (position.getX() == 0 && position.getY() == 0);
    }
}
