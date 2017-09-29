package com.epam.university.java.core.task016;

public class CoordinateImpl implements Coordinate {
    private int xcoord;
    private int ycoord;

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Coordinate)
                && (xcoord == ((Coordinate) obj).getX())
                && (ycoord == ((Coordinate) obj).getY());
    }

    @Override
    public int getX() {
        return xcoord;
    }

    @Override
    public void setX(int x) {
        xcoord = x;
    }

    @Override
    public int getY() {
        return ycoord;
    }

    @Override
    public void setY(int y) {
        ycoord = y;
    }
}
