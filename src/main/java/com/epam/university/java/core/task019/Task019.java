package com.epam.university.java.core.task019;

/**
 * Robotics.
 */
public interface Task019 {
    /**
     * Invoke robot command.
     * @param robot robot to work with
     * @param command command to execute
     */
    void invokeAction(Robot robot, RobotCommand command);

    /**
     * Is robot now on it's start position.
     * @param robot robot to check
     * @return is robot on start position
     */
    boolean isOnStartPosition(Robot robot);
}
