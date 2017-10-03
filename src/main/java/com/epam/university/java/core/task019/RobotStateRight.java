package com.epam.university.java.core.task019;

import com.epam.university.java.core.utils.common.Validator;

/**
 * Class implements <code>RobotState</code> for case when machine heading east.
 */
class RobotStateRight implements RobotState {
    private RobotPosition currentRobotPosition;
    private RobotPosition initialRobotPosition;

    /**
     * Initialisation of this class.
     *
     * @param currentRobotPosition current machine position in two-dimensional
     *                             plane
     * @param initialRobotPosition initial machine position in two-dimensional
     *                             plane
     * @throws IllegalArgumentException if at least one of parameters is null
     */
    public RobotStateRight(RobotPosition currentRobotPosition, RobotPosition
            initialRobotPosition) {
        Validator.validateNotNull(currentRobotPosition, initialRobotPosition,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        this.currentRobotPosition = currentRobotPosition;
        this.initialRobotPosition = initialRobotPosition;
    }

    @Override
    public RobotPosition getPosition() {
        return currentRobotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        Validator.validateNotNull(position,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        currentRobotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        Validator.validateNotNull(command, Validator
                .MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEnum(command, RobotCommand.values(),
                Validator.MESSAGE_IF_ILLEGAL_ARGUMENT);
        setPosition(new RobotPositionImpl(getPosition()
                .getX() + 1, getPosition().getY()));
    }
}
