package com.epam.university.java.core.task019;

import com.epam.university.java.core.utils.common.Validator;

import static com.epam.university.java.core.task019.RobotCommand.MOVE_FORWARD;
import static com.epam.university.java.core.task019.RobotCommand.TURN_LEFT;
import static com.epam.university.java.core.task019.RobotCommand.TURN_RIGHT;

/**
 * Class - implementation of Robot, that can walk through two-dimensional
 * coordinates.
 */
public class RobotImpl implements Robot {

    private RobotState currentRobotState;
    private RobotPosition currentRobotPosition;
    private RobotPosition initialRobotPosition;

    /**
     * Initialisation of <code>RobotImpl</code>.
     *
     * @param currentRobotPosition current position of machine
     * @param initialRobotPosition initial position of machine
     * @throws IllegalArgumentException if at least one of parameters is null
     */
    public RobotImpl(RobotPosition currentRobotPosition, RobotPosition
            initialRobotPosition) {
        Validator.validateNotNull(currentRobotPosition, initialRobotPosition,
                Validator.MESSAGE_FOR_FIRST_PARAMETER_IF_NULL,
                Validator.MESSAGE_FOR_SECOND_PARAMETER_IF_NULL);
        this.currentRobotPosition = currentRobotPosition;
        this.initialRobotPosition = initialRobotPosition;
    }

    /**
     * Initialisation of <code>RobotImpl</code> with no arguments.
     */
    public RobotImpl() {
        currentRobotState = new RobotStateForward();
        currentRobotPosition = new RobotPositionImpl();
        initialRobotPosition = currentRobotPosition;
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

    /**
     * Get initial position of machine.
     *
     * @return <code>RobotPosition</code>
     */
    public RobotPosition getInitialRobotPosition() {
        return initialRobotPosition;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        Validator.validateNotNull(command,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEnum(command, RobotCommand.values(),
                Validator.MESSAGE_IF_ILLEGAL_ARGUMENT);

        if (command.equals(MOVE_FORWARD)) {
            currentRobotState.invokeAction(MOVE_FORWARD);
            setPosition(currentRobotState.getPosition());
        } else {
            changeRobotState(command);
        }
    }


    /**
     * Change state of machine.
     *
     * @param command command that triggers the machine state
     * @throws IllegalArgumentException if command is null or not belongs to
     *                                  the Enum
     */
    public void changeRobotState(RobotCommand command) {
        Validator.validateNotNull(command,
                Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        Validator.validateEnum(command, RobotCommand.values(),
                Validator.MESSAGE_IF_ILLEGAL_ARGUMENT);

        if (command.equals(TURN_RIGHT)) {
            if (currentRobotState instanceof RobotStateForward) {
                currentRobotState = new RobotStateRight(currentRobotPosition,
                        initialRobotPosition);
            } else if (currentRobotState instanceof RobotStateRight) {
                currentRobotState = new RobotStateBack(currentRobotPosition,
                        initialRobotPosition);
            } else if (currentRobotState instanceof RobotStateBack) {
                currentRobotState = new RobotStateLeft(currentRobotPosition,
                        initialRobotPosition);
            } else if (currentRobotState instanceof RobotStateLeft) {
                currentRobotState = new RobotStateForward(currentRobotPosition,
                        initialRobotPosition);
            }
        }

        if (command.equals(TURN_LEFT)) {
            if (currentRobotState instanceof RobotStateForward) {
                currentRobotState = new RobotStateLeft(currentRobotPosition,
                        initialRobotPosition);
            } else if (currentRobotState instanceof RobotStateLeft) {
                currentRobotState = new RobotStateBack(currentRobotPosition,
                        initialRobotPosition);
            } else if (currentRobotState instanceof RobotStateBack) {
                currentRobotState = new RobotStateRight(currentRobotPosition,
                        initialRobotPosition);
            } else if (currentRobotState instanceof RobotStateRight) {
                currentRobotState = new RobotStateForward(currentRobotPosition,
                        initialRobotPosition);
            }
        }
    }
}