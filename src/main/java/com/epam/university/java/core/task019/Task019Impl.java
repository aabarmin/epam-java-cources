package com.epam.university.java.core.task019;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Class implements Task019.
 */
public class Task019Impl implements Task019 {
    @Override
    public void invokeAction(Robot robot, RobotCommand command) {
        Validator.validateNotNull(robot, command,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        Validator.validateEnum(command, RobotCommand.values(),
                Validator.MESSAGE_IF_ILLEGAL_ARGUMENT);
        robot.invokeAction(command);
    }

    @Override
    public boolean isOnStartPosition(Robot robot) {
        Validator.validateNotNull(robot, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        return ((RobotImpl) robot).getInitialRobotPosition()
                .equals(robot.getPosition());
    }
}
