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
        mxValue = Math.round(pxValue * 1000000) / 1000000.0;
        myValue = Math.round(pyValue * 1000000) / 1000000.0;
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
        mxValue = Math.round(pxValue * 1000000) / 1000000.0;

    }

    @Override
    public void setY(double pyValue) {
        myValue = Math.round(pyValue * 1000000) / 1000000.0;

    }

    @Override
    public String toString() {
        return "PointImpl{"
                + "mxValue=" + mxValue
                + ", myValue=" + myValue
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PointImpl point = (PointImpl) o;

        if (Double.compare(point.mxValue, mxValue) != 0) {
            return false;
        }
        return Double.compare(point.myValue, myValue) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(mxValue);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(myValue);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
