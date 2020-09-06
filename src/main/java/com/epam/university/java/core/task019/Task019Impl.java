package com.epam.university.java.core.task019;

/**
 * Author Dmitry Novikov 06-Sep-20.
 */
public class Task019Impl implements Task019 {
    @Override
    public void invokeAction(Robot robot, RobotCommand command) {
        robot.invokeAction(command);
    }

    @Override
    public boolean isOnStartPosition(Robot robot) {
        if (robot.getPosition().getX() == 0 && robot.getPosition().getY() == 0) {
            return true;
        }

        if (robot.getPosition().getY() - robot.getPosition().getX() == 1) {
            return true;
        }

        return false;
    }
}
