package com.epam.university.java.core.task016;

public class CoordinateImpl implements Coordinate {
    int x;
    int y;

    /**
     * Just a constructor.
     *
     * @param x - coordinate
     * @param y - coordinate
     */
    public CoordinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get x coordinate value.
     *
     * @return coordinate value
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * Set x coordinate value.
     *
     * @param x coordinate value
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Get y coordinate value.
     *
     * @return coordinate value
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Set y coordinate value.
     *
     * @param y coordinate value
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Method to check if this object is eqial to coordinate.
     *
     * @param coordinate object to check
     * @return true is equals
     */
    @Override
    public boolean equals(Object coordinate) {
        if (coordinate instanceof Coordinate) {
            if (this.getX() == ((Coordinate) coordinate).getX()
                    && this.getY() == ((Coordinate) coordinate).getY()) {
                return true;
            }
        }
        return false;
    }
}
