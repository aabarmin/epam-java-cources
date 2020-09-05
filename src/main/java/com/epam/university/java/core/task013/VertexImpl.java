package com.epam.university.java.core.task013;

/**
 * author Dmitry Novikov.
 */
public class VertexImpl implements Vertex {
    private int x;
    private int y;

    public VertexImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int value) {
        x = value;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int value) {
        y = value;
    }

    @Override
    public int compareTo(Vertex o) {
        if (x != o.getX()) {
            return Double.compare(x, o.getX());
        } else {
            return Double.compare(y, o.getY());
        }

    }
}
