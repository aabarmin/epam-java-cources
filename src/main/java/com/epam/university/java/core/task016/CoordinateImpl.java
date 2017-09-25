package com.epam.university.java.core.task016;

/**
 * Implementation class for Coordinate.
 *
 * @author Sergei Titov
 */
public class CoordinateImpl implements Coordinate {

    private int abscissa;
    private int ordinate;

    protected CoordinateImpl(int x, int y) {
        abscissa = x;
        ordinate = y;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getX() {
        return abscissa;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setX(int x) {
        abscissa = x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getY() {
        return ordinate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setY(int y) {
        ordinate = y;
    }


    @Override
    /**
     * Compares internals of CoordinateImpl class
     *
     * @param obj is an object to compare with.
     *
     * @returns true if (this.(x, y) == obj.(x, y))
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof CoordinateImpl)) {
            return false;
        }
        return (((CoordinateImpl) obj).getX() == abscissa && ((CoordinateImpl) obj).getY() == ordinate);
    }
}
