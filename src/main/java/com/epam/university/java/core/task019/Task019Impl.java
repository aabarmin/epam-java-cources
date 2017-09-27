package com.epam.university.java.core.task019;

/**
 * Created by Daniil Smirnov on 22.09.2017.
 * All copy registered MF.
 */
public class Task019Impl implements Task019 {

    @Override
    public void invokeAction(Robot robot, RobotCommand command) {
        robot.invokeAction(command);
    }

    @Override
    public boolean isOnStartPosition(Robot robot) {
        return (robot.getPosition().getX() == 0 && robot.getPosition().getY() == 0);
    }
}
