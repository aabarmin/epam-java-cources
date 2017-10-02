package com.epam.university.java.core.task013;

public class VertexImpl implements Vertex {
    int x;
    int y;
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
