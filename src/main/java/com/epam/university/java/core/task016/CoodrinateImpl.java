package com.epam.university.java.core.task016;

import java.util.Objects;

/**
 * Author Dmitry Novikov 05-Sep-20.
 */
public class CoodrinateImpl implements Coordinate {
    private int x;
    private int y;

    public CoodrinateImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null
                || getClass() != o.getClass()) {
            return false;
        }
        CoodrinateImpl that = (CoodrinateImpl) o;
        return x == that.x
                && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

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
