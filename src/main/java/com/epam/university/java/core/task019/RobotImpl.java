package com.epam.university.java.core.task019;

import static com.epam.university.java.core.task019.RobotCommand.MOVE_FORWARD;
import static com.epam.university.java.core.task019.RobotCommand.TURN_LEFT;
import static com.epam.university.java.core.task019.RobotCommand.TURN_RIGHT;

public class RobotImpl implements Robot {

    private RobotState currentRobotState;
    private RobotPosition currentRobotPosition;
    private RobotPosition initialRobotPosition;

    public RobotImpl(RobotPosition currentRobotPosition, RobotPosition
            initialRobotPosition) {
        this.currentRobotPosition = currentRobotPosition;
        this.initialRobotPosition = initialRobotPosition;
    }

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
        currentRobotPosition = position;
    }

    public RobotPosition getInitialRobotPosition() {
        return initialRobotPosition;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        if (command.equals(MOVE_FORWARD)) {
            currentRobotState.invokeAction(MOVE_FORWARD);
            setPosition(currentRobotState.getPosition());
        }
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
        System.out.println("current robot position: " + currentRobotPosition
                + System.lineSeparator());
    }
}
