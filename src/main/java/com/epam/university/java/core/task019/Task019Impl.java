package com.epam.university.java.core.task019;

/**
 * Created by Вера on 25.09.2017.
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
        } else {
            return false;
        }
    }
}
