package com.epam.university.java.core.task019;

/**
 * {@inheritDoc}
 */
public class Task019Impl implements Task019 {
    /**
     * {@inheritDoc}
     */
    @Override
    public void invokeAction(Robot robot, RobotCommand command) {
        robot.invokeAction(command);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOnStartPosition(Robot robot) {
        return robot.getPosition().getX() == 0
                && robot.getPosition().getY() == 0;
    }
}
