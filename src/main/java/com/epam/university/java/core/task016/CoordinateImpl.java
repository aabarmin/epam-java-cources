package com.epam.university.java.core.task016;

/**
 * Created by Вера on 24.09.2017.
 */
public class CoordinateImpl implements Coordinate {
    private int x;
    private int y;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
