package com.epam.university.java.core.task019;

/**
 * Implementation class for Task019.
 *
 * @author Sergei Titov
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

        // same as when?! Let's guess same as when created
        return (0 == robot.getPosition().getX() && 0 == robot.getPosition().getY());
    }
}
