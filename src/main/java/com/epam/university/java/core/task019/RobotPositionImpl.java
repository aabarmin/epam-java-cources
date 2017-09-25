package com.epam.university.java.core.task019;

/**
 * Created by Daniil Smirnov on 22.09.2017.
 * All copy registered MF.
 */
public class RobotPositionImpl implements RobotPosition {

    private int pointX;
    private int pointY;

    @Override
    public int getPointX() {
        return pointX;
    }

    @Override
    public int getPointY() {
        return pointY;
    }

    @Override
    public void setPointX(int pointX) {
        this.pointX = pointX;
    }

    @Override
    public void setPointY(int pointY) {
        this.pointY = pointY;
    }
}
