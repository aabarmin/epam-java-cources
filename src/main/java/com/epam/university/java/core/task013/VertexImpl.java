package com.epam.university.java.core.task013;

/**
 * Created by ilya on 15.09.17.
 */
public class VertexImpl implements Vertex {
    private int x;
    private int y;

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
}
