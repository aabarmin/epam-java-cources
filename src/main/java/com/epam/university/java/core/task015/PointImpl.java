package com.epam.university.java.core.task015;

public class PointImpl implements Point {
    private double mxValue;
    private double myValue;

    /**
     * All args constructor.
     *
     * @param pxValue value of X
     * @param pyValue value of Y
     */
    public PointImpl(double pxValue, double pyValue) {
        mxValue = pxValue;
        myValue = pyValue;
    }

    @Override
    public double getX() {
        return mxValue;
    }

    @Override
    public double getY() {
        return myValue;
    }

    @Override
    public void setX(double pxValue) {
        mxValue = pxValue;

    }

    @Override
    public void setY(double pyValue) {
        myValue = pyValue;

    }
}
