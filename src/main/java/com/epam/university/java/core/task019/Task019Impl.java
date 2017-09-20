package com.epam.university.java.core.task019;

public class Task019Impl implements Task019 {
    /**
     * Invoke robot command.
     *
     * @param robot   robot to work with
     * @param command command to execute
     */
    @Override
    public void invokeAction(Robot robot, RobotCommand command) {

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
        return true;
    }
}
