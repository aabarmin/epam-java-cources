package com.epam.university.java.core.task019;

import com.epam.university.java.core.utils.geometricprimitives.Point2D;

public interface RobotState extends Robot {
}

class RobotStateForward implements RobotState {
    private RobotPosition currentRobotPosition;
    private RobotPosition initialRobotPosition;

    public RobotStateForward(RobotPosition currentRobotPosition, RobotPosition
            initialRobotPosition) {
        this.currentRobotPosition = currentRobotPosition;
        this.initialRobotPosition = initialRobotPosition;
    }

    public RobotStateForward() {
        this.currentRobotPosition = new RobotPositionImpl(0,
                0);
    }

    @Override
    public RobotPosition getPosition() {
        return currentRobotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        currentRobotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        setPosition(new RobotPositionImpl(getPosition().getX(),
                getPosition().getY() + 1));
    }
}

class RobotStateRight implements RobotState {
    private RobotPosition currentRobotPosition;
    private RobotPosition initialRobotPosition;

    public RobotStateRight(RobotPosition currentRobotPosition, RobotPosition
            initialRobotPosition) {
        this.currentRobotPosition = currentRobotPosition;
        this.initialRobotPosition = initialRobotPosition;
    }

    @Override
    public RobotPosition getPosition() {
        return currentRobotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        currentRobotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        setPosition(new RobotPositionImpl(getPosition()
                .getX() + 1, getPosition().getY()));
    }
}

class RobotStateLeft implements RobotState {
    private RobotPosition currentRobotPosition;
    private RobotPosition initialRobotPosition;

    public RobotStateLeft(RobotPosition currentRobotPosition, RobotPosition
            initialRobotPosition) {
        this.currentRobotPosition = currentRobotPosition;
        this.initialRobotPosition = initialRobotPosition;
    }

    @Override
    public RobotPosition getPosition() {
        return currentRobotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        currentRobotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        setPosition(new RobotPositionImpl(getPosition()
                .getX() - 1, getPosition().getY()));
    }
}

class RobotStateBack implements RobotState {
    private RobotPosition currentRobotPosition;
    private RobotPosition initialRobotPosition;

    public RobotStateBack(RobotPosition currentRobotPosition, RobotPosition
            initialRobotPosition) {
        this.currentRobotPosition = currentRobotPosition;
        this.initialRobotPosition = initialRobotPosition;
    }

    @Override
    public RobotPosition getPosition() {
        return currentRobotPosition;
    }

    @Override
    public void setPosition(RobotPosition position) {
        currentRobotPosition = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {
        setPosition(new RobotPositionImpl(getPosition()
                .getX(), getPosition().getY() - 1));
    }
}