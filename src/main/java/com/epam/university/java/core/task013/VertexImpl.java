package com.epam.university.java.core.task013;

/**
 * Created by Вера on 20.09.2017.
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
        this.x = value;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int value) {
        this.y = value;
    }
}
