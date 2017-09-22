package com.epam.university.java.core.task019;

/**
 * Created by ilya on 21.09.17.
 */
public class Task019Impl implements Task019 {

    private final RobotPosition startPosition = new RobotPositionImpl(0, 0);

    @Override
    public void invokeAction(Robot robot, RobotCommand command) {
        robot.invokeAction(command);
    }

    @Override
    public boolean isOnStartPosition(Robot robot) {
        return startPosition.equals(robot.getPosition());
    }
}
